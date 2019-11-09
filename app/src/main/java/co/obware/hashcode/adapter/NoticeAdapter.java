package co.obware.hashcode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.obware.hashcode.MVP.NoticeType;
import co.obware.hashcode.R;


public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.Holder> {

    private Context context;
    private List<NoticeType> list;

    String strNumber;
    public NoticeAdapter(List<NoticeType> list){
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( context );
        View view = layoutInflater.inflate( R.layout.recyclerview_enotice, parent, false );
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int i) {
        final NoticeType noticeType = list.get(i);
        final String strNumber= noticeType.getDate();
        holder.img.setImageResource( noticeType.getImage() );
        holder.tv_header.setText( noticeType.getTitle() );
        holder.tv_details.setText(noticeType.getContent());
        holder.tv_date.setText( noticeType.getDate() );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        TextView tv_header;
        TextView tv_details;
        TextView tv_date;
        ImageView img;

        Holder(View view) {
            super( view );
            tv_header = view.findViewById( R.id.tv_notice_title );
            tv_details = view.findViewById( R.id.tv_notice_content );
            tv_date = view.findViewById( R.id.tv_notice_date );
            img = view.findViewById( R.id.image_notice );
        }
    }

}