package cn.anline.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TitleListView extends ListActivity {
    private String[] mListTitle = {"姓名","年龄","居住地","邮箱","手机号码"};
    private String[] mListStr = {"罗正安","21","云南楚雄","an@asmm.cn","13529513104"};
    ListView mListView = null;
    ArrayList<Map<String,Object>>mData =new ArrayList<Map<String,Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mListView = getListView();
        int lengh = mListTitle.length;
        for (int i =0;i<lengh;i++){
            Map<String,Object> item =new HashMap<String, Object>();
            item.put("title",mListTitle[i]);
            item.put("text",mListStr[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mData,android.R.layout.simple_list_item_2,new String[]{"title","text"},new int[]{android.R.id.text1,android.R.id.text2});
        setListAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"您选择了：id--"+position+"   内容--"+mListTitle[position],Toast.LENGTH_SHORT).show();
            }
        });
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_title_list_view);
    }
}
