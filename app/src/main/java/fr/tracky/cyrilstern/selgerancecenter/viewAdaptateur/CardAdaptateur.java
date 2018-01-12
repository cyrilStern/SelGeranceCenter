package fr.tracky.cyrilstern.selgerancecenter.viewAdaptateur;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import fr.tracky.cyrilstern.selgerancecenter.LoginActivity;
import fr.tracky.cyrilstern.selgerancecenter.R;

/**
 * Created by cyrilstern1 on 11/01/2018.
 */

public class CardAdaptateur extends RecyclerView.Adapter<CardAdaptateur.ViewHolder> {
        private List<CardApplication> cardApplicationList;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CardAdaptateur(List<CardApplication> cardApplicationList, Context context) {
        this.cardApplicationList = cardApplicationList;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(CardAdaptateur.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
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
                try {
                    holder.cardView1.setBackground(Drawable.createFromStream(context.getResources().getAssets().open(cardApplicationList.get(position).getBackGroundImageLeft()), null));
                    holder.cardView2.setBackground(Drawable.createFromStream(context.getResources().getAssets().open(cardApplicationList.get(position).getBackGroundImageRight()), null));
                    holder.cardView2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(context, LoginActivity.class);
                            context.startActivities(new Intent[]{intent});
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    private static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private CardView cardView1;
        private CardView cardView2;

        private ViewHolder(View v) {
            super(v);
            cardView1 = v.findViewById(R.id.card_viewLeft);
            cardView2 = v.findViewById(R.id.card_viewRight);
        }
        }
}

