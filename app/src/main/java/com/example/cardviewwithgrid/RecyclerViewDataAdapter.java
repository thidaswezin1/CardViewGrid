package com.example.cardviewwithgrid;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;


public class RecyclerViewDataAdapter  extends RecyclerView.Adapter<RecyclerViewItemHolder> {

    private List<RecyclerViewItem> carItemList;

    public RecyclerViewDataAdapter(List<RecyclerViewItem> carItemList) {
        this.carItemList = carItemList;
    }

    @Override
    public RecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Get LayoutInflater object.
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the RecyclerView item layout xml.
        View carItemView = layoutInflater.inflate(R.layout.activity_card_view_item, parent, false);

        // Get car title text view object.
        final TextView carTitleView = (TextView)carItemView.findViewById(R.id.card_view_image_title);
        // Get car image view object.
        final ImageView carImageView = (ImageView)carItemView.findViewById(R.id.card_view_image);
        // When click the image.
        carImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get car title text.
                String carTitle = carTitleView.getText().toString();
                // Create a snackbar and show it.
                Snackbar snackbar = Snackbar.make(carImageView, "You click " + carTitle +" image", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        // Create and return our custom Car Recycler View Item Holder object.
        RecyclerViewItemHolder ret = new RecyclerViewItemHolder(carItemView);
        return ret;
    }

    @Override
    public void onBindViewHolder(RecyclerViewItemHolder holder, int position) {
        if(carItemList!=null) {
            // Get car item dto in list.
            RecyclerViewItem carItem = carItemList.get(position);

            if(carItem != null) {
                // Set car item title.
                holder.getCarTitleText().setText(carItem.getCarName());
                // Set car image resource id.
                holder.getCarImageView().setImageResource(carItem.getCarImageId());
            }
        }
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(carItemList!=null)
        {
            ret = carItemList.size();
        }
        return ret;
    }
}
