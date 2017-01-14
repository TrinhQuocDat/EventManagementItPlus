package eventmanagement.project.itplus.eventmanagement.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import eventmanagement.project.itplus.eventmanagement.Model.Event;
import eventmanagement.project.itplus.eventmanagement.R;

/**
 * Created by Dat UET on 1/10/2017.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder>{
    public static ArrayList<Event> arrayList;
    public EventAdapter(ArrayList<Event> arr) {
        arrayList = arr;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgIconEvent;
        private TextView txtNameEvent,txtTimeEvent,txtAddressEvent,txtCountLike;
        private ImageButton imgFavorite;
        private CardView cardViewMain;

        public ViewHolder(View itemView) {
            super(itemView);
            imgIconEvent = (ImageView) itemView.findViewById(R.id.imgIconEvent);
            txtNameEvent = (TextView) itemView.findViewById(R.id.txtNameEvent);
            txtTimeEvent = (TextView) itemView.findViewById(R.id.txtTimeEvent);
            txtAddressEvent = (TextView) itemView.findViewById(R.id.txtAddressEvent);
            cardViewMain = (CardView) itemView.findViewById(R.id.mainCardView);
            //txtCountLike = (TextView) itemView.findViewById(R.id.txtCountLike);
            //imgFavorite = (ImageButton) itemView.findViewById(R.id.imgFavorite);

        }
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventAdapter.ViewHolder holder, int position) {
        //set 1 item
        holder.txtNameEvent.setText(arrayList.get(position).getName());
        holder.txtTimeEvent.setText(String.valueOf(arrayList.get(position).getTime()));
        holder.txtAddressEvent.setText(arrayList.get(position).getAddress());


//
//        //bat su kien
//        holder.imgFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //bat su kien khi click vao nut sao (imgFavorite)
//
//            }
//        });
//        holder.cardViewMain.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //bat su kien khi click vao Main Event
//                Log.e("Card Click",String.valueOf(position));
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}
