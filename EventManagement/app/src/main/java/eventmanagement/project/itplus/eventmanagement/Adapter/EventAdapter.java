package eventmanagement.project.itplus.eventmanagement.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import eventmanagement.project.itplus.eventmanagement.Inteface.EventClickListener;
import eventmanagement.project.itplus.eventmanagement.Model.Event;
import eventmanagement.project.itplus.eventmanagement.R;

/**
 * Created by Dat UET on 1/10/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{
    private  ArrayList<Event> events;
    private Context mContext;
    private EventClickListener mEventClickListener;

    public EventAdapter(ArrayList<Event> events, Context mContext, EventClickListener mEventClickListener) {
        this.events = events;
        this.mContext = mContext;
        this.mEventClickListener = mEventClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imgIconEvent;
        private TextView txtNameEvent,txtTimeEvent,txtAddressEvent,txtCountLike;
        private ImageView popupMenu;

        public ViewHolder(View itemView) {
            super(itemView);
            imgIconEvent = (ImageView) itemView.findViewById(R.id.imgIconEvent);
            txtNameEvent = (TextView) itemView.findViewById(R.id.txtNameEvent);
            txtTimeEvent = (TextView) itemView.findViewById(R.id.txtTimeEvent);
            txtAddressEvent = (TextView) itemView.findViewById(R.id.txtAddressEvent);
            popupMenu = (ImageView) itemView.findViewById(R.id.popup_menu);
            itemView.setOnClickListener(this);
            popupMenu.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(view == itemView){
                mEventClickListener.onItemClick(view,getAdapterPosition());
            }else {
                mEventClickListener.onPopupMenuItemClick(view,getAdapterPosition());
            }
        }
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {
        //set 1 item
        holder.txtNameEvent.setText(events.get(position).getName());
        holder.txtTimeEvent.setText(String.valueOf(events.get(position).getTime()));
        holder.txtAddressEvent.setText(events.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

}
