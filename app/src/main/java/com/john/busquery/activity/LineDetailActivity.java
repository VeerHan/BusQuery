package com.john.busquery.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

/**
 * 线路详情
 */
public class LineDetailActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.listView)
    ListView listView;
    private List<Map<String, String>> data = new ArrayList<>();
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_detail);
        ButterKnife.inject(this);
        queue = Volley.newRequestQueue(this);
        String line = getIntent().getStringExtra("line");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setTitle(line);
        getData(Constant.app_key, Constant.city_id, line);
    }

    private void getData(final String appKey, final String cityId, final String line) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API.LINE, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String status = jsonObject.getString("status");
                    //0代表有路线数据，否则代表查询不到此路线
                    if (status.equals("0")) {
                        JSONArray result = jsonObject.getJSONArray("result");
                        JSONArray list = result.getJSONObject(0).getJSONArray("list");
                        for (int i = 0; i < list.length(); i++) {
                            Map<String, String> map = new HashMap<>();
                            map.put("station", list.getJSONObject(i).getString("station"));
                            data.add(map);
                        }
                        listView.setAdapter(new SimpleAdapter(LineDetailActivity.this, data, android.R.layout.simple_list_item_1, new String[]{"station"}, new int[]{android.R.id.text1}));

                    } else {
                        Toast.makeText(LineDetailActivity.this, "没有信息", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(LineDetailActivity.this, "网络连接已断开，请稍后重试", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("appkey", appKey);
                map.put("cityid", cityId);
                map.put("transitno", line);
                return map;
            }
        };

        queue.add(stringRequest);
    }

}
