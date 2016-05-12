package com.example.drawerlaout2;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class activity_settingmain extends Fragment {

	Button btnToPassword;
	Button btnToNikename;
	Button btnToGender;
	Button btnToInterest;
	Button btnToPhoneNum;
	Button btnToMail;
	Button btnToPrivacy;
	private static final String TAG = "activity_settingmain";

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		System.out.println(TAG+"------"+"onCreate");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println(TAG+"------onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.activity_settingmain, null);
		btnToGender = (Button)view.findViewById(R.id.changeGender);
		btnToGender.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				ToGender(v);
			}
		});
		btnToNikename = (Button)view.findViewById(R.id.changeName);
		btnToNikename.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				ToNikename(v);
			}
		});
		btnToInterest = (Button)view.findViewById(R.id.changeInterest);
		btnToInterest.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				ToInterest(v);
			}
		});
		btnToPhoneNum = (Button)view.findViewById(R.id.changePhoneNum);
		btnToPhoneNum.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				ToPhoneNum(v);
			}
		});
		btnToMail = (Button)view.findViewById(R.id.changemail);
		btnToMail.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				ToMail(v);
			}
		});
		btnToPrivacy = (Button)view.findViewById(R.id.changeprivacy);
		btnToPrivacy.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				ToPrivacy(v);
			}
		});
		System.out.println(TAG+"------onCreateView");
		return view;
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println(TAG+"------onStart");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println(TAG+"------onResume");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		System.out.println(TAG+"------onPause");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		System.out.println(TAG+"------onStop");
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		System.out.println(TAG+"------onDestroyView");
	}


	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println(TAG+"------onDestroy");
	}



	public void ToPassword(View view)
	{
		Intent intent = new Intent(activity_settingmain.this.getActivity(), ModifypasswordActivity.class);
		startActivity(intent);
	}
	public void ToNikename(View view)
	{
		Intent intent = new Intent(activity_settingmain.this.getActivity(), Modifynikename.class);
		startActivity(intent);
	}
	public void ToGender(View view)
	{
		Intent intent = new Intent(activity_settingmain.this.getActivity(), Modifygender.class);
		startActivity(intent);
	}
	public void ToInterest(View view)
	{
		Intent intent = new Intent(activity_settingmain.this.getActivity(), ModifyInterest.class);
		startActivity(intent);
	}
	public void ToPhoneNum(View view)
	{
		Intent intent = new Intent(activity_settingmain.this.getActivity(), Modifyphonenumber.class);
		startActivity(intent);
	}
	public void ToMail(View view)
	{
		Intent intent = new Intent(activity_settingmain.this.getActivity(), Modifymail.class);
		startActivity(intent);
	}
	public void ToPrivacy(View view)
	{
		Intent intent = new Intent(activity_settingmain.this.getActivity(), Modifyprivacy.class);
		startActivity(intent);
	}
}
