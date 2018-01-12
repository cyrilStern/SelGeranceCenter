package fr.tracky.cyrilstern.selgerancecenter.viewAdaptateur;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import fr.tracky.cyrilstern.selgerancecenter.R;

/**
 * Created by cyrilstern1 on 11/01/2018.
 */

public class CardAdaptateur extends RecyclerView.Adapter<CardAdaptateur.ViewHolder> {
        private List<CardApplication> cardApplicationList;

    @Override
    public void onBindViewHolder(CardAdaptateur.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            private CardView cardView1;
            private CardView cardView2;
            public ViewHolder(View v) {
                super(v);
                cardView1 = v.findViewById(R.id.card_viewLeft);
                cardView2 = v.findViewById(R.id.card_viewRight);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public CardAdaptateur(List<CardApplication> cardApplicationList) {
            this.cardApplicationList = cardApplicationList;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public CardAdaptateur.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_view, parent, false);

            return new ViewHolder(itemView);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
              //  holder.cardView1.setBackground(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
               // holder.cardView2.setBackground(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
            }
            else {
              //  holder.cardView1.setBackgroundDrawable(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
              //  holder.cardView2.setBackgroundDrawable(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return cardApplicationList.size();
        }
}

