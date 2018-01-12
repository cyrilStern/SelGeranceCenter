package fr.tracky.cyrilstern.selgerancecenter.viewAdaptateur;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import fr.tracky.cyrilstern.selgerancecenter.R;
import fr.tracky.cyrilstern.selgerancecenter.factories.ActivitySelFactory;

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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            try {
                holder.cardView1.setBackground(Drawable.createFromStream(context.getResources().getAssets().open(cardApplicationList.get(position).getBackGroundImageLeft()), null));
                holder.cardView2.setBackground(Drawable.createFromStream(context.getResources().getAssets().open(cardApplicationList.get(position).getBackGroundImageRight()), null));
                activityClickListener(holder.cardView1, position, cardApplicationList.get(position).getTextApplicationLeft());
                activityClickListener(holder.cardView2, position, cardApplicationList.get(position).getTextApplicationRight());

            } catch (IOException e) {
                e.printStackTrace();
            }
            //  holder.cardView1.setBackground(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
            // holder.cardView2.setBackground(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
        } else {
            //  holder.cardView1.setBackgroundDrawable(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
            //  holder.cardView2.setBackgroundDrawable(Drawable.createFromPath(Uri.parse("android.resource://fr.tracky.cyrilstern.selgerancecenter/drawable/"+cardApplicationList.get(position).getBackGroundImageLeft()).getPath()));
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cardApplicationList.size();
    }

    /**
     * launch activity bind by text on click card
     *
     * @param view
     * @param position
     * @param activityName
     */
    private void activityClickListener(View view, final int position, final String activityName) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName("fr.tracky.cyrilstern.selgerancecenter", ActivitySelFactory.activity(cardApplicationList.get(position).getTextApplicationLeft())));
                    context.startActivities(new Intent[]{new Intent(intent)});
                } catch (Exception e) {
                    Log.d("onclickListener", e.getMessage());
                }
            }
        });

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
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

