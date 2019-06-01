package com.example.android.app;

import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public TextView question;
    public int num = 1;
    public int crcanss = 0;
    public Button option1, option2, option3, option4;
    public DatabaseReference ref;
    public DatabaseReference reference;
    Handler handler=new Handler();
    Thread t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        reference = FirebaseDatabase.getInstance().getReference();
        option4 = findViewById(R.id.option4);
        MyThread t=new MyThread();
        t1=new Thread();
        t1.start();

    }




    public class MyThread implements Runnable {
        DatabaseReference reference;
        int num=1;



        DatabaseReference ref;
        public void MyThread(DatabaseReference reference)
        {
            this.reference=reference;
        }
        public void run() {

            setLayout();

        }
        public void setLayout() {
            if (num > 2) {

            } else {
                ref = reference.child("num");
                num++;
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                {
                                    final Question qes = dataSnapshot.getValue(Question.class);
                                    question.setText(qes.getQuestion());
                                    option1.setText(qes.getOption1());
                                    option2.setText(qes.getOption2());
                                    option3.setText(qes.getOption3());
                                    option4.setText(qes.getOption4());


                                    option1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (qes.getCrcans().equals(qes.getOption1())) {
                                                option1.setBackgroundColor(Color.GREEN);
                                                crcanss++;

                                            } else {
                                                option1.setBackgroundColor(Color.RED);
                                                if (qes.getCrcans().equals(qes.getOption2())) {
                                                    option2.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption3())) {
                                                    option3.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption4())) {
                                                    option4.setBackgroundColor(Color.GREEN);
                                                }
                                            }
                                            
                                            setLayout();


                                        }

                                    });
                                    option2.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (qes.getCrcans().equals(qes.getOption2())) {
                                                option2.setBackgroundColor(Color.GREEN);
                                                crcanss++;

                                            } else {
                                                option2.setBackgroundColor(Color.RED);
                                                if (qes.getCrcans().equals(qes.getOption1())) {
                                                    option1.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption3())) {
                                                    option3.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption4())) {
                                                    option4.setBackgroundColor(Color.GREEN);
                                                }
                                            }

                                            setLayout();


                                        }

                                    });
                                    option3.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (qes.getCrcans().equals(qes.getOption3())) {
                                                option3.setBackgroundColor(Color.GREEN);
                                                crcanss++;

                                            } else {
                                                option3.setBackgroundColor(Color.RED);
                                                if (qes.getCrcans().equals(qes.getOption2())) {
                                                    option2.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption1())) {
                                                    option1.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption4())) {
                                                    option4.setBackgroundColor(Color.GREEN);
                                                }
                                            }

                                            setLayout();


                                        }

                                    });
                                    option4.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            if (qes.getCrcans().equals(qes.getOption4())) {
                                                option4.setBackgroundColor(Color.GREEN);
                                                crcanss++;

                                            } else {
                                                option4.setBackgroundColor(Color.RED);
                                                if (qes.getCrcans().equals(qes.getOption2())) {
                                                    option2.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption3())) {
                                                    option3.setBackgroundColor(Color.GREEN);
                                                } else if (qes.getCrcans().equals(qes.getOption1())) {
                                                    option1.setBackgroundColor(Color.GREEN);
                                                }
                                            }

                                            setLayout();
                                        }

                                    });
                                }

                            }
                        });

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        }
    }


}