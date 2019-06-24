package com.thaliees.buttonfilter.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.thaliees.buttonfilter.R;
import java.util.ArrayList;

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder> {
    private String[] tags;
    private View.OnClickListener itemListener;
    private Context context;
    private ArrayList<Button> buttons = new ArrayList<>();

    public TagAdapter(String[] tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Save the context (Only if you need to use it in other methods of this class)
        context = viewGroup.getContext();
        // Create a new view with the layout indicated
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tag_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // Replace the contents of a view for each position
        viewHolder.getTagItem().setText(tags[position]);
        // Save also the value in your tag to identify when the user click
        viewHolder.getTagItem().setTag(tags[position]);
        // Change color to the first button
        if (position == 0) viewHolder.getTagItem().setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        // Add to the array each button
        buttons.add(viewHolder.tagItem);
    }

    @Override
    public int getItemCount() {
        return tags.length;
    }

    public void setItemListener(View.OnClickListener itemListener) {
        this.itemListener = itemListener;
    }

    public void changeColorAll(){
        for (Button button: buttons) {
            button.setBackgroundColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    // Creation of class that provide a reference to the type of views that you are using
    public class ViewHolder extends RecyclerView.ViewHolder{
        private final Button tagItem;

        // Define the elements and the events (if exist) of the ViewHolder's View
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tagItem = itemView.findViewById(R.id.tagItem);
            tagItem.setOnClickListener(itemListener);
        }

        // Define get for each element
        public Button getTagItem() {
            return tagItem;
        }
    }
}
