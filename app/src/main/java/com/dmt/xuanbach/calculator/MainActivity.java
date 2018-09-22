package com.dmt.xuanbach.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private Button mBTnb1, mBTnb2,mBTnb3,mBTnb4,mBTnb5,mBTnb6,mBTnb7,mBTnb8,mBTnb9,mBTnb0;
   private Button mBTsub,mBTadd,mBTmul,mBTdiv;
   private Button mBTrs,mBTdot,mBTAC,mBTC;
   private EditText mEdtNumb;
   private TextView mTvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setEvent();
    }
    public void init(){
        mBTnb0=(Button) findViewById(R.id.btnNumber0);
        mBTnb1=(Button) findViewById(R.id.btnNumber1);
        mBTnb2=(Button) findViewById(R.id.btnNumber2);
        mBTnb3=(Button) findViewById(R.id.btnNumber3);
        mBTnb4=(Button) findViewById(R.id.btnNumber4);
        mBTnb5=(Button) findViewById(R.id.btnNumber5);
        mBTnb6=(Button) findViewById(R.id.btnNumber6);
        mBTnb7=(Button) findViewById(R.id.btnNumber7);
        mBTnb8=(Button) findViewById(R.id.btnNumber8);
        mBTnb9=(Button) findViewById(R.id.btnNumber9);
        mBTsub=(Button) findViewById(R.id.btnSub);
        mBTadd=(Button) findViewById(R.id.btnAdd);
        mBTmul=(Button) findViewById(R.id.btnMul);
        mBTdiv=(Button) findViewById(R.id.btnDiv);
        mBTdot=(Button) findViewById(R.id.btnPoint);
        mBTAC =(Button) findViewById(R.id.btnClearAll);
        mBTC  =(Button) findViewById(R.id.btnClear);
        mBTrs=(Button) findViewById(R.id.btnResult);

        mEdtNumb=(EditText)findViewById(R.id.edt_input) ;
        mTvResult=(TextView) findViewById(R.id.tv_result) ;

    }
    public  void setEvent(){
        mBTnb1.setOnClickListener(this);
        mBTnb2.setOnClickListener(this);
        mBTnb3.setOnClickListener(this);
        mBTnb4.setOnClickListener(this);
        mBTnb5.setOnClickListener(this);
        mBTnb6.setOnClickListener(this);
        mBTnb7.setOnClickListener(this);
        mBTnb8.setOnClickListener(this);
        mBTnb9.setOnClickListener(this);
        mBTnb0.setOnClickListener(this);

        mBTsub.setOnClickListener(this);
        mBTadd.setOnClickListener(this);
        mBTmul.setOnClickListener(this);
        mBTdiv.setOnClickListener(this);

        mBTrs.setOnClickListener(this);
        mBTdot.setOnClickListener(this);
        mBTAC.setOnClickListener(this);
        mBTC.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnNumber0:
                    mEdtNumb.append("0");
                    break;
                case R.id.btnNumber1 :
                    mEdtNumb.append("1");
                    break;
                case R.id.btnNumber2 :
                    mEdtNumb.append("2");
                    break;
                case R.id.btnNumber3 :
                    mEdtNumb.append("3");
                    break;
                case R.id.btnNumber4 :
                    mEdtNumb.append("4");
                    break;
                case R.id.btnNumber5 :
                    mEdtNumb.append("5");
                    break;
                case R.id.btnNumber6 :
                    mEdtNumb.append("6");
                    break;
                case R.id.btnNumber7 :
                    mEdtNumb.append("7");
                    break;
                case R.id.btnNumber8 :
                    mEdtNumb.append("8");
                    break;
                case R.id.btnNumber9 :
                    mEdtNumb.append("9");
                    break;
                case R.id.btnAdd :
                    mEdtNumb.append("+");
                    break;
                case R.id.btnSub :
                    mEdtNumb.append("-");
                    break;
                case R.id.btnMul :
                    mEdtNumb.append("*");
                    break;
                case R.id.btnDiv :
                    mEdtNumb.append("/");
                    break;
                case R.id.btnClear :
//                    String box= delete(mEdtNumb.getText().toString());
//                    mEdtNumb.setText(box);
                    BaseInputConnection TextInputConnection = new BaseInputConnection(mEdtNumb,true);
                    TextInputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN,KeyEvent.KEYCODE_DEL));
                    break;
                case R.id.btnClearAll :
                    mEdtNumb.setText("");
                    break;
                case R.id.btnPoint :
                    mEdtNumb.append(".");
                    break;
                case R.id.btnResult :
                    double result=0;
                   addOperation(mEdtNumb.getText().toString());
                    addNumber(mEdtNumb.getText().toString());
                    //thuat toan
                    if(arrOperation.size()>=arrNumber.size()){
                        mTvResult.setText("loi dinh dang");
                    }else{
                        for(int i=0; i<(arrNumber.size()-1);i++){
                            switch (arrOperation.get(i)){
                                case "+":
                                    if(i==0){
                                        result= arrNumber.get(i)+arrNumber.get(i+1);
                                    }
                                    else{
                                        result= result + arrNumber.get(i+1);
                                    }
                                    break;
                                case "-":
                                    if(i==0){
                                        result= arrNumber.get(i)-arrNumber.get(i+1);
                                    }
                                    else{
                                        result= result - arrNumber.get(i+1);
                                    }
                                    break;
                                case "*":
                                    if(i==0){
                                        result= arrNumber.get(i)*arrNumber.get(i+1);
                                    }
                                    else{
                                        result= result *arrNumber.get(i+1);
                                    }
                                    break;
                                case "/":
                                    if(i==0){
                                        result= arrNumber.get(i)/arrNumber.get(i+1);
                                    }
                                    else{
                                        result= result /arrNumber.get(i+1);
                                    }
                                    break;
                                    default:
                                        break;
                            }
                        }
                        mTvResult.setText(result+"");
                    }



            }
    }

    public ArrayList<String> arrOperation;
    public ArrayList<Double> arrNumber;
    public int addOperation( String input){
        arrOperation=new ArrayList<>();
        char[] cArray = input.toCharArray();
        for (int i=0; i<cArray.length;i++){
            switch (cArray[i]){
                case '+':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '-':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '*':
                    arrOperation.add(cArray[i]+"");
                    break;
                case '/':
                    arrOperation.add(cArray[i]+"");
                    break;
                    default:
                        break;
            }
        }
        return 0;
    }
    public  void addNumber(String stringInput){
        arrNumber= new ArrayList<>();
        Pattern regex=Pattern.compile("\\d+(?:\\.\\d+)?");
        Matcher matcher= regex.matcher(stringInput);
        while (matcher.find()) {

           //arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}
