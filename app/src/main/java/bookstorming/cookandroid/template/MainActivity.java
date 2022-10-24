package bookstorming.cookandroid.template;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.cookandroid.template.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Book> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerVies);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList=new ArrayList<>();//책 객체를 담을 어레이 리스트

        database=FirebaseDatabase.getInstance();

        databaseReference=database.getReference("Book");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어베이스 데이터베이스에 데이터를 받아오는 메소드
                arrayList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Book book = snapshot.getValue(Book.class);//북 객체에 데이터 담음
                    arrayList.add(book);//담은 데이터를 배열리스트에 추가
                }
                adapter.notifyDataSetChanged();//리스트 저장및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("MainActivity",String.valueOf(databaseError.toException()));

            }
        });

        adapter = new BookAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);//리사이클러 뷰에 어댑터 연결

    }
}