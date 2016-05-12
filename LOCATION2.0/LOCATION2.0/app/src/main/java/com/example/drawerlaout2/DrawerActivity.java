package com.example.drawerlaout2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DrawerActivity extends Activity
{
	private ListView lv;
	private String[] strList;
    private DrawerLayout mDrawerLayout = null;
    private TitleLayout layout = null;
    private FragmentManager fragmentManager = getFragmentManager();
    private LinearLayout leftRoot = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initComp();
        initData();        
        initFragment();
    }

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void initFragment() {
		// TODO Auto-generated method stub
		//Ĭ�ϴ�DemoFragment1
		fragmentManager.beginTransaction()
		.replace(R.id.content_frame, new map()).commit();
	}

	private void initData() {
		// TODO Auto-generated method stub
		layout.getBackView().setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mDrawerLayout.openDrawer(Gravity.LEFT);
			}
		});
		
		strList = getResources().getStringArray(R.array.items);
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, getData()));
		lv.setOnItemClickListener(new OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                lv.setItemChecked(position, true);
                mDrawerLayout.closeDrawer(leftRoot);
                Fragment fragment = null;
                System.out.println("pos = " + position + ":position % 4" + position % 4);
                switch (position % 5) {

                    case 0:
                        fragment = new map();
                        break;
                    case 1:
                        fragment = new activity_addfriend();
                        break;
                    case 2:
                        fragment = new activity_friendlist();
                        break;
                    case 3:
                        fragment = new activity_settingmain();
                        break;
                    case 4:
                        fragment = new activity_help();
                        break;
                    default:
                        break;
                }
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment).commit();
            }
        });
	}

	private void initComp() {
        // TODO Auto-generated method stub
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        layout = (TitleLayout) findViewById(R.id.title);
        lv = (ListView) findViewById(R.id.left_drawer);
        leftRoot = (LinearLayout) findViewById(R.id.left_root);
    }
        private List<String> getData(){

            List<String> data = new ArrayList<String>();
            data.add("导    航");
            data.add("添加好友");
            data.add("好友列表");
            data.add("个人中心");
            data.add("关    于");
            return data;
        }
	}
