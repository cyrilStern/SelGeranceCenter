package fr.tracky.cyrilstern.selgerancecenter.viewAdaptateur;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    /**
     * @param cardApplicationList
     * @param context
     */
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
                .inflate(R.layout.card_application_view, parent, false);

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
                cardApplicationList.get(position).getBackGroundImageLeft();

                /**
                 * code to remove card if it's empty information
                 */
                if (cardApplicationList.size() < 2) {
                    holder.linearLayout.removeView(holder.cardView2);
                }
                ImageView imageView = new ImageView(this.context);
                imageView.setImageResource(R.drawable.ic_meteor);
                ImageView imageView2 = new ImageView(this.context);
                imageView2.setImageResource(R.drawable.ic_raspberrypi);
                holder.cardView1.addView(imageView);
                holder.cardView2.addView(imageView2);
                holder.textViewCardView1.setText(cardApplicationList.get(position).getTextApplicationLeft());
                holder.textViewCardView2.setText(cardApplicationList.get(position).getTextApplicationRight());

                holder.cardView1.setBackgroundResource(cardApplicationList.get(position).getBackGroundImageLeft());
                holder.cardView2.setBackgroundResource(cardApplicationList.get(position).getBackGroundImageRight());
                // holder.cardView2.setBackground(Drawable.createFromStream(context.getResources().getAssets().open(cardApplicationList.get(position).getBackGroundImageRight()), null));
                activityClickListener(holder.cardView1, position, cardApplicationList.get(position).getTextApplicationLeft());
                activityClickListener(holder.cardView2, position, cardApplicationList.get(position).getTextApplicationRight());

            } catch (Exception e) {
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

    /**
     * holder implementation bind view <> xml
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final CardView cardView1;
        private final CardView cardView2;
        private final LinearLayout linearLayout;
        private final TextView textViewCardView1;
        private final TextView textViewCardView2;


        private ViewHolder(View v) {
            super(v);
            cardView1 = v.findViewById(R.id.card_viewLeft);
            cardView2 = v.findViewById(R.id.card_viewRight);
            linearLayout = v.findViewById(R.id.linearCardview);
            textViewCardView1 = v.findViewById(R.id.card_left_text);
            textViewCardView2 = v.findViewById(R.id.card_right_text);
        }
        }
}

