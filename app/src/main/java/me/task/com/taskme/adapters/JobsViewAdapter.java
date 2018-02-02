package me.task.com.taskme.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.task.com.taskme.R;
import me.task.com.taskme.models.JobPosts;

/**
 * Created by root on 12/1/17.
 */

public class JobsViewAdapter extends RecyclerView.Adapter<JobsViewAdapter.JobsViewHolder> {
    
    private List<JobPosts> jobs;
    private Context context;

    public JobsViewAdapter(Context context, List<JobPosts> jobs) {
        // TODO Auto-generated constructor stub
        this.jobs = jobs;
        this.context = context;
    }

    public class JobsViewHolder extends RecyclerView.ViewHolder {

        public TextView txtJobCategory, txtClient, datetxt;
        public ImageView imageView;

        public JobsViewHolder(View itemView) {
            super(itemView);

            txtJobCategory = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.icon);
            txtClient = (TextView) itemView.findViewById(R.id.client);
            datetxt = (TextView) itemView.findViewById(R.id.date_time);
        }
    }
    @Override
    public JobsViewAdapter.JobsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_latest, parent, false);
        return new JobsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JobsViewHolder holder, int position) {
        //        declare and initialize the client and job post id
        int client_id = jobs.get(position).getClient_id();
        int job_post_id = jobs.get(position).getJob_post_id();
        //        .load(jobs.get(position).getUrlToImage())
        Picasso.with(context)
                .load(R.drawable.image)
                .placeholder(R.drawable.error)
                .into(holder.imageView);


        holder.txtJobCategory.setText(jobs.get(position).getJob_category());
//        holder.txtClient.setText(jobs.get(position).getClient());
        holder.datetxt.setText(jobs.get(position).getCreated_at());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }
}