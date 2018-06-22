package com.example.booklist.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.booklist.R;
import com.example.booklist.model.Book;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    Activity activity;
    int resource;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);

        activity = (Activity)context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView; //ListView에게 되돌려 받은 레이아웃 객체

        if(itemView == null) {
            // 최초 호출시에 null이므로 생성자의 파라미터로 전달받은 리소스 아이디 값을 사용하여 레이아웃 생성
            itemView = this.activity.getLayoutInflater().inflate(this.resource, null);
        }

        // 데이터가 존재한다면 레이아웃 객체에 포함된 컴포넌트에게 데이터를 출력
        Book item = getItem(position);
        if(item != null) {
            ImageView imageView = (ImageView)itemView.findViewById(R.id.imageView);
            TextView textView1 = (TextView)itemView.findViewById(R.id.textView1);
            TextView textView2 = (TextView)itemView.findViewById(R.id.textView2);
            TextView textView3 = (TextView)itemView.findViewById(R.id.textView3);
            TextView textView4 = (TextView)itemView.findViewById(R.id.textView4);

            imageView.setImageResource(item.getImage());
            textView1.setText(item.getSubject());
            textView2.setText(item.getWriter());
            textView3.setText(item.getPublisher());
            textView4.setText(item.getStroy());
        }
        return itemView; //리스트뷰에게 넘김
    }
}
