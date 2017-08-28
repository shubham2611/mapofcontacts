package com.example.seth.assignment;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    List<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button)findViewById(R.id.button);
        Button button1=(Button)findViewById(R.id.button1);
        final TextView text=(TextView) findViewById(R.id.editText);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        DownloadManager downloadManager=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                        Uri ur=Uri.parse("http://www.cs.columbia.edu/~coms6998-8/assignments/homework2/contacts/contacts.txt");
                        DownloadManager.Request request=new DownloadManager.Request(ur);
                        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                        Long refer=downloadManager.enqueue(request);
                        try {
                            DataInputStream input=new DataInputStream(getAssets().open(String.format("contacts.txt")));
                            Scanner sc=new Scanner(input);
                            while(sc.hasNext())
                            {
                             list.add(sc.next());
                            }
                        } catch (IOException e) {
                            text.setText("Failed to open file");
                        }
                        //int size=list.size();
                        Intent intent=new Intent(ContactsContract.Intents.Insert.ACTION);
                        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                        for(int i=0;i<list.size();i=i+4)
                        {
                            intent
                            .putExtra(ContactsContract.Intents.Insert.NAME,list.get(i))
                            .putExtra(ContactsContract.Intents.Insert.EMAIL,list.get(i+1))
                            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE,ContactsContract.CommonDataKinds.Email.TYPE_WORK)
                            .putExtra(ContactsContract.Intents.Insert.PHONE,list.get(i+2))
                            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                                    .putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE,list.get(i+3))
                                    .putExtra(ContactsContract.Intents.Insert.SECONDARY_PHONE_TYPE,ContactsContract.CommonDataKinds.Phone.TYPE_HOME);
                        startActivity(intent);
                        }
                    }
                }
        );


        button1.setOnClickListener(new
        Button.OnClickListener(){

            public void onClick(View v){
                Intent in=new Intent(MainActivity.this,MapsActivity.class);
                in.putExtra("h1",list.get(2));
                in.putExtra("h2",list.get(3));
                in.putExtra("h3",list.get(6));
                in.putExtra("h4",list.get(7));
                in.putExtra("h5",list.get(10));
                in.putExtra("h6",list.get(11));
                in.putExtra("h7",list.get(14));in.putExtra("h8",list.get(15));
                in.putExtra("h9",list.get(18));in.putExtra("h10",list.get(19));
                startActivity(in);
            }
        }
        );

    }
}
