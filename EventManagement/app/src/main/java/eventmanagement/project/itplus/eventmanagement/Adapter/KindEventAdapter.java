package eventmanagement.project.itplus.eventmanagement.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import eventmanagement.project.itplus.eventmanagement.Inteface.EventClickListener;
import eventmanagement.project.itplus.eventmanagement.Model.Category;
import eventmanagement.project.itplus.eventmanagement.R;

/**
 * Created by Dat UET on 1/15/2017.
 */

public class KindEventAdapter extends RecyclerView.Adapter<KindEventAdapter.MyViewHolder>{
    private ArrayList<Category> categories;
    private Context context;
    private EventClickListener mEventClickListener;

    public KindEventAdapter(ArrayList<Category> categories, Context context, EventClickListener mEventClickListener) {
        this.categories = categories;
        this.context = context;
        this.mEventClickListener = mEventClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category category = categories.get(position);
        Glide.with(context).load(category.getImage()).into(holder.circleImageView);
        holder.category.setText(category.getName());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CircleImageView circleImageView;
        private TextView category;
        public MyViewHolder(View itemView) {
            super(itemView);
            circleImageView = (CircleImageView)itemView.findViewById(R.id.image);
            category = (TextView) itemView.findViewById(R.id.category);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mEventClickListener.onItemClick(view,getAdapterPosition());
        }
    }
}
