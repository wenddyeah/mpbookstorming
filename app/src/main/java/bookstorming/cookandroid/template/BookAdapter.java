package bookstorming.cookandroid.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cookandroid.template.R;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{


    private ArrayList<Book> arrayList;
    private Context context;


    public BookAdapter(ArrayList<Book> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context=context;
    }



    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        BookViewHolder holder =new BookViewHolder(view);

        return holder;
    }

    @Override//imageview불러오기
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {
        Glide.with(holder.itemView).load(arrayList.get(position).getProfile()).into(holder.iv_profile);
        holder.tv_tt.setText(arrayList.get(position).getTitle());
        holder.tv_dp.setText(arrayList.get(position).getDescription());
        holder.tv_dt.setText(String.valueOf(arrayList.get(position).getPubDate()));



    }

    @Override
    public int getItemCount() {//사망연산자
        return (arrayList !=null?arrayList.size():0);
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_profile;
        TextView tv_tt;
        TextView tv_dp;
        TextView tv_dt;


        public BookViewHolder(@NonNull View itemView){
            super(itemView);
            this.iv_profile=itemView.findViewById(R.id.tv_profile);
            this.tv_tt=itemView.findViewById(R.id.tv_tt);
            this.tv_dp=itemView.findViewById(R.id.tv_dp);
            this.tv_dt=itemView.findViewById(R.id.tv_dt);

        }

    }
}
