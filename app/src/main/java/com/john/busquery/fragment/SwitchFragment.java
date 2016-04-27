package com.john.busquery.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.john.busquery.R;
import com.john.busquery.activity.LineDetailActivity;
import com.john.busquery.adapter.SwitchAdapter;
import com.john.busquery.bean.API;
import com.john.busquery.bean.Constant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SwitchFragment extends Fragment {

    @InjectView(R.id.et_start)
    EditText etStart;
    @InjectView(R.id.et_end)
    EditText etEnd;
    @InjectView(R.id.btn_search)
    Button btnSearch;
    @InjectView(R.id.listView)
    ListView listView;
    @InjectView(R.id.tv_tip)
    TextView tvTip;
    private View view;
    private RequestQueue queue;
    private List<Map<String, String>> data;
    private SwitchAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        data = new ArrayList<>();
        adapter = new SwitchAdapter(getActivity(), data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_switch, null);
        ButterKnife.inject(this, view);
        queue = Volley.newRequestQueue(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, String> map = data.get(position);
                String line = map.get("line");
                Intent intent = new Intent(getActivity(), LineDetailActivity.class);
                intent.putExtra("line", line);
                startActivity(intent);
            }
        });
    }

    @OnClick(R.id.btn_search)
    public void onClick() {
        String startStation = etStart.getText().toString().trim();
        String endStation = etEnd.getText().toString().trim();
        getData(startStation, endStation);
    }

    private void getData(final String startStation, final String endStation) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API.SWITCH, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                data.clear();
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String status = jsonObject.getString("status");
                    //0代表有路线数据，否则代表查询不到此路线
                    if (status.equals("0")) {
                        JSONArray result = jsonObject.getJSONArray("result");
                        JSONObject object = result.getJSONObject(0);
                        //总公里数
                        String distance = object.getString("totaldistance");
                        //总时长
                        String time = object.getString("totalduration");
                        JSONArray steps = object.getJSONArray("steps");
                        for (int i = 0; i < steps.length(); i++) {
                            JSONObject step = steps.getJSONObject(i);
                            String type = step.getString("type");
                            if (type.equals("3")) {
                                JSONObject vehicle = step.getJSONObject("vehicle");
                                String line = vehicle.getString("name");
                                String text = step.getString("steptext");
                                Map<String, String> map = new HashMap<>();
                                map.put("text", text);
                                map.put("line", line);
                                data.add(map);
                            }
                        }
                        Log.d("temp", "data = " + data.toString());
                        tvTip.setText("总公里数: " + distance + "        " + "总时长: " + time);
                        adapter.notifyDataSetChanged();
                    } else {
                        Toast.makeText(getActivity(), R.string.no_info, Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                data.clear();
                Toast.makeText(getActivity(), R.string.error_net, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("appkey", Constant.app_key);
                map.put("city", "淮安");
                map.put("start", startStation);
                map.put("end", endStation);
                map.put("type", "transit");
                return map;
            }
        };
        queue.add(stringRequest);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
