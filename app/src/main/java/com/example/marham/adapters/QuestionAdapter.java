package com.example.marham.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marham.R;
import com.example.marham.models.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.MyViewHolder>  implements Filterable {


    private final ArrayList<Question> questions;
    private final ArrayList<Question> questionsFiltered;
    Context context;


    public QuestionAdapter(Context context, ArrayList<Question> questions) {
        this.questions = new ArrayList<>(questions);;
        this.context = context;
        this.questionsFiltered = questions;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_recyclerview_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Question question = questionsFiltered.get(position);

        holder.title.setText(question.getTitle());
        holder.time.setText(question.getTime());
        holder.query.setText(question.getQuery());
        holder.image.setImageResource(question.getImage());
        holder.subHeading.setText( question.getAskingFor() +", " + question.getGender() +", "+question.getAge()+" years old, "+ question.getCity());

        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,question.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public int getItemCount() {
        return questionsFiltered.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView title, subHeading, query , time;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            title = (TextView) itemView.findViewById(R.id.title);
            query = (TextView) itemView.findViewById(R.id.query);
            subHeading = (TextView) itemView.findViewById(R.id.subheading);
            time = (TextView) itemView.findViewById(R.id.time);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    @Override
    public Filter getFilter() {
        return Searched_Filter;
    }
    private Filter Searched_Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Question> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(questions);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Question item :questions) {
                    if (item.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            questionsFiltered.clear();
            questionsFiltered.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
}
