package me.task.com.taskme.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import me.task.com.taskme.R;
import me.task.com.taskme.models.JobPost;
import me.task.com.taskme.models.JobPosts;

/**
 * Created by root on 12/1/17.
 */

public class JobsRecyclerViewAdapter extends RecyclerView.Adapter<JobsRecyclerViewAdapter.ViewHolder> {
    
    private JobPosts jobs;
    private Context context;

    public JobsRecyclerViewAdapter(Context context, JobPosts jobs) {
        // TODO Auto-generated constructor stub
        this.jobs = jobs;
        this.context = context;
    }

    public View getView(int position, View view, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (view == null) {            
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_latest, parent, false);
        }

        TextView txtJobCategory = (TextView) view.findViewById(R.id.title);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        TextView txtClient = (TextView) view.findViewById(R.id.client);
        TextView datetxt = (TextView) view.findViewById(R.id.date_time);

//        declare and initialize the client and job post id
        int client_id = jobs.getJobPosts().get(position).getClient_id();
        int job_post_id = jobs.getJobPosts().get(position).getJob_post_id();

//        .load(jobs.get(position).getUrlToImage())
        Picasso.with(context)
                .load(R.drawable.image)
                .placeholder(R.drawable.error)
                .into(imageView);
        txtJobCategory.setText(jobs.getJobPosts().get(position).getJob_category());
//        txtClient.setText(jobs.get(position).getClient());
        datetxt.setText(jobs.getJobPosts().get(position).getCreatedAt());
        return view;

    }

    @Override
    public JobsRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_latest, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(JobsRecyclerViewAdapter.ViewHolder holder, int position) {
        final JobPost user = jobs.getJobPosts().get(position);
//        declare and initialize the client and job post id
        int client_id = jobs.getJobPosts().get(position).getClient_id();
        int job_post_id = jobs.getJobPosts().get(position).getJob_post_id();

//        .load(jobs.get(position).getUrlToImage())
        Picasso.with(context)
                .load(R.drawable.image)
                .placeholder(R.drawable.error)
                .into(holder.imageView);
        holder.txtJobCategory.setText(jobs.getJobPosts().get(position).getJob_category());
//        holder.txtClient.setText(jobs.get(position).getClient());
        holder.datetxt.setText(jobs.getJobPosts().get(position).getCreatedAt());

    }

    @Override
    public int getItemCount() {
        return jobs.getJobPosts().size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtJobCategory, txtClient, datetxt;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            txtJobCategory = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.icon);
            txtClient = (TextView) itemView.findViewById(R.id.client);
            datetxt = (TextView) itemView.findViewById(R.id.date_time);
        }
    }
}