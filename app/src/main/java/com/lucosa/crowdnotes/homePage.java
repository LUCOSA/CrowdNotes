package com.lucosa.crowdnotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class homePage extends Fragment {

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    public homePage() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_page, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList data = new ArrayList<BookGetter>();
        for (int i = 0; i < Book.Titles.length; i++) {
            data.add(
                    new BookGetter(
                            Book.Titles[i],
                            Book.Authors[i],
                            Book.Descriptions[i],
                            Book.Thumbnails[i]
                    )
            );
        }

        listAdapter = new ListAdapter(data);
        recyclerView.setAdapter(listAdapter);

        // Inflate the layout for this fragment
        return view;

    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

        private ArrayList<BookGetter> arrayList;

        public ListAdapter(ArrayList<BookGetter> data) {
            this.arrayList = data;
        }

        public  class ViewHolder extends RecyclerView.ViewHolder {

            TextView titleTextView;
            TextView authorTextView;
            ImageView thumbnailImageView;

            public ViewHolder(View view) {
                super(view);

                titleTextView = view.findViewById(R.id.book_title_text);
                authorTextView = view.findViewById(R.id.book_author_text);
                thumbnailImageView = view.findViewById(R.id.book_image_page);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_card_view,
                    parent, false);

            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {
            holder.titleTextView.setText(arrayList.get(position).getTitle());
            holder.authorTextView.setText(arrayList.get(position).getAuthor());
            holder.thumbnailImageView.setImageResource(arrayList.get(position).getThumbnail());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "Book " + position + " opening.",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }
}
