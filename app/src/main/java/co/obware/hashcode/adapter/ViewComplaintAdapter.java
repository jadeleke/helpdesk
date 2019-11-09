package co.obware.hashcode.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.obware.hashcode.MVP.ViewComplaintType;
import co.obware.hashcode.R;


public class ViewComplaintAdapter extends RecyclerView.Adapter<ViewComplaintAdapter.Holder> {

    private Context context;
    private List<ViewComplaintType> list;

    String strNumber;
    public ViewComplaintAdapter(Context contexts, List<ViewComplaintType> list){
        this.context = contexts;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from( context );
        View view = layoutInflater.inflate( R.layout.recyclerview_view_complaint, parent, false );
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int i) {
        final ViewComplaintType noticeType = list.get(i);
        final String strNumber= noticeType.getDate();
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

        Holder(View view) {
            super( view );
            tv_header = view.findViewById( R.id.tv_notice_title );
            tv_details = view.findViewById( R.id.tv_notice_content );
            tv_date = view.findViewById( R.id.tv_notice_date );
        }
    }

}