package com.daimao.bluebubble.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.daimao.bluebubble.R.layout.activity_list_view);

        setTitle("ListView");

        final ListView listView = (ListView) findViewById(com.daimao.bluebubble.R.id.list_view);

        LayoutInflater layoutInflater = getLayoutInflater();

        View header = layoutInflater.inflate(com.daimao.bluebubble.R.layout.list_item_header_footer, null);
        View footer = layoutInflater.inflate(com.daimao.bluebubble.R.layout.list_item_header_footer, null);
        TextView txtHeaderTitle = (TextView) header.findViewById(com.daimao.bluebubble.R.id.txt_title);
        TextView txtFooterTitle =  (TextView) footer.findViewById(com.daimao.bluebubble.R.id.txt_title);
        txtHeaderTitle.setText("THE HEADER!");
        txtFooterTitle.setText("THE FOOTER!");

        listView.addHeaderView(header);
        listView.addFooterView(footer);

        final SampleAdapter adapter = new SampleAdapter(this, com.daimao.bluebubble.R.id.txt_line1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        final List<String> sampleData = SampleData.generateSampleData();
        for (String data : sampleData) {
            adapter.add(data);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
    }
}
