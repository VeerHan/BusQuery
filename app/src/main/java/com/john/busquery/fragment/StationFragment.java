package com.john.busquery.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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

public class StationFragment extends Fragment {

    @InjectView(R.id.et_station)
    EditText etStation;
    @InjectView(R.id.btn_search)
    Button btnSearch;
    @InjectView(R.id.listView)
    ListView listView;
    private View view;
    private List<Map<String, String>> data = new ArrayList<>();
    private RequestQueue queue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_station, null);
        ButterKnife.inject(this, view);
        queue = Volley.newRequestQueue(getActivity());
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
        return view;
    }

    @OnClick(R.id.btn_search)
    public void onClick() {
        data.clear();
        String stationName = etStation.getText().toString().trim();
        getData(Constant.app_key, Constant.city_id, stationName);
    }


    private void getData(final String appKey, final String cityId, final String station) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API.STATION, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String status = jsonObject.getString("status");
                    //0代表有站点数据，否则代表查询不到此站点
                    if (status.equals("0")) {
                        JSONArray result = jsonObject.getJSONArray("result");
                        for (int i = 0; i < result.length(); i = i + 2) {
                            Map<String, String> map = new HashMap<>();
                            map.put("line", result.getJSONObject(i).getString("transitno"));
                            data.add(map);
                        }
                        listView.setAdapter(new SimpleAdapter(getActivity(), data, android.R.layout.simple_list_item_1, new String[]{"line"}, new int[]{android.R.id.text1}));

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
                Toast.makeText(getActivity(), R.string.error_net, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("appkey", appKey);
                map.put("cityid", cityId);
                map.put("station", station);
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
