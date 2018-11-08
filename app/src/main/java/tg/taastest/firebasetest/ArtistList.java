package tg.taastest.firebasetest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArtistList extends ArrayAdapter<Artist> {
    private Activity context;
    private List<Artist> artistList;

    public ArtistList(Activity context, List<Artist> artistList) {
        super(context,R.layout.list_layout);
        this.context=context;
        this.artistList = artistList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        LayoutInflater inflater = context.getLayoutInflater();
        View ListViewItem= inflater.inflate(R.layout.list_layout,null,true);
        TextView txtname= (TextView) ListViewItem.findViewById(R.id.txtName);
        TextView txtgenre = (TextView) ListViewItem.findViewById(R.id.txtgenre);
        return ListViewItem;
    }
}
