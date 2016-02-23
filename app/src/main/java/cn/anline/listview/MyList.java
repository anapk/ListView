package cn.anline.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyList extends ListActivity {
    private String[] anListTitle = {"安浪创想","网站","业务","邮箱","编程","姓名","GitHUB","QQ","微博","微信","产品","手机","地址"};
    private String[] anListStr = {"创造财富，成就梦想！","www.anline.cn","网站开发、服务器、APP、微信、信息安全","an@asmm.cn","HTML5 CSS3 Javascript C/C++ Java Python Objective-C Swift Go","罗正安","https://github.com/jiankian","746586176","http://weibo.com/jiankian","jiankian","安绚科技","13529513104","中国,云南,楚雄"};
    ListView anListView = null;
    ArrayList<Map<String,Object>> aData =new ArrayList<Map<String,Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        anListView = getListView();
        int aLength = anListTitle.length;
        for(int i =0;i<aLength;i++){
            Map<String,Object> item = new HashMap<String, Object>();
            item.put("title",anListTitle[i]);
            item.put("text",anListStr[i]);
            aData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this, aData, android.R.layout.simple_list_item_2, new String[]{"title", "text"}, new int[]{android.R.id.text1, android.R.id.text2});
        setListAdapter(adapter);
        anListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"标题："+anListTitle[position]+"   内容："+anListStr[position],Toast.LENGTH_SHORT).show();
            }
        });
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_list);
    }
}
