package com.example.prettycalculator;

import com.example.prettycalculator.R;

import android.text.TextUtils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	final int MENU_RESET_ID = 1;
	final int MENU_TWO_AND_TWO = 2;
	final int MENU_EXIT_ID = 3;
	
	
	
	  EditText etNum1;
	  EditText etNum2;

	  ImageButton btnAdd;
	  ImageButton btnSub;
	  ImageButton btnMult;
	  ImageButton btnDiv;

	  TextView tvResult;

	  String oper = "";

	  /** Called when the activity is first created. */
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    // find the elements
	    etNum1 = (EditText) findViewById(R.id.etNum1);
	    etNum2 = (EditText) findViewById(R.id.etNum2);

	    btnAdd = (ImageButton) findViewById(R.id.btnAdd);
	    btnSub = (ImageButton) findViewById(R.id.btnSub);
	    btnMult = (ImageButton) findViewById(R.id.btnMult);
	    btnDiv = (ImageButton) findViewById(R.id.btnDiv);

	    tvResult = (TextView) findViewById(R.id.tvResult);

	    // set a listener
	    btnAdd.setOnClickListener(this);
	    btnSub.setOnClickListener(this);
	    btnMult.setOnClickListener(this);
	    btnDiv.setOnClickListener(this);

	  }

	  @Override
	  public void onClick(View v) {
	    // TODO Auto-generated method stub
	    float num1 = 0;
	    float num2 = 0;
	    float result = 0;

	    // check if the fields are empty
	    if (TextUtils.isEmpty(etNum1.getText().toString())
	        || TextUtils.isEmpty(etNum2.getText().toString())) {
	      return;
	    }

	    // read EditText and fill variables with numbers
	    num1 = Float.parseFloat(etNum1.getText().toString());
	    num2 = Float.parseFloat(etNum2.getText().toString());

	    // defines the button that has been clicked and performs the corresponding operation
	    // write operation into oper, we will use it later for output
	    switch (v.getId()) {
	    case R.id.btnAdd:
	      oper = "+";
	      result = num1 + num2;
	      break;
	    case R.id.btnSub:
	      oper = "-";
	      result = num1 - num2;
	      break;
	    case R.id.btnMult:
	      oper = "*";
	      result = num1 * num2;
	      break;
	    case R.id.btnDiv:
	      oper = "/";
	      result = num1 / num2;
	      break;
	    default:
	      break;
	    }
	    
	    
	    

	    // form the output line
	    tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
	  }

	

@Override
public boolean onCreateOptionsMenu(Menu menu) {
  // TODO Auto-generated method stub
  menu.add(0, MENU_RESET_ID, 0, "Reset");
  menu.add(0, MENU_EXIT_ID, 1, "Exit");
  menu.add(0, MENU_TWO_AND_TWO, 2, "Two and Two");
  return super.onCreateOptionsMenu(menu);
}

// process menu item clicks
@Override
public boolean onOptionsItemSelected(MenuItem item) {
  // TODO Auto-generated method stub
  switch (item.getItemId()) {
  case MENU_RESET_ID:
    // clear the fields
    etNum1.setText("");
    etNum2.setText("");
    tvResult.setText("");
    break;
  case MENU_EXIT_ID:
    // exit the application
    finish();
    break;
  case MENU_TWO_AND_TWO:
	//add two plus two
	etNum1.setText("2");
	etNum2.setText("2");
  }
  return super.onOptionsItemSelected(item);
}
}