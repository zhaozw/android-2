package be.ugent.oomo.groep12.studgent.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import be.ugent.oomo.groep12.studgent.R;
import be.ugent.oomo.groep12.studgent.common.Trophie;
import be.ugent.oomo.groep12.studgent.common.TrophieFilter;

public class TrophieAdapter extends ArrayAdapter<Trophie> implements Filterable{
    static class TrophieItemHolder
    {
        TextView name;
        TextView value;
    }
	
    Context context; 
    int layoutResourceId;    
    List<Trophie> data = new ArrayList<Trophie>();
    private Filter mFilter;
    
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new TrophieFilter(this);
        }
        return mFilter;
    }

	public TrophieAdapter(Context context, int layoutResourceId) {
		super(context, layoutResourceId);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
	}
	public TrophieAdapter(Context context, int layoutResourceId, List<Trophie> objects) {
		super(context, layoutResourceId, objects);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = objects;
	}
	

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        TrophieItemHolder holder = null;
        
        if (row == null) {
        	//System.out.println("ruw==null");
        	LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new TrophieItemHolder();
            holder.name = (TextView)row.findViewById(R.id.trophie_item_name); 
            holder.value = (TextView)row.findViewById(R.id.trofie_item_value);
            row.setTag(holder);
        } else {
            holder = (TrophieItemHolder)row.getTag();
        }
        
        Trophie trophie_item = data.get(position);
        //System.out.println("Friend friend_item: "+data.get(position).getName());
        
        holder.name.setText(Html.fromHtml("" +  trophie_item.getName() ));
        holder.value.setText( "" + trophie_item.getPoints());
        //holder.image.setImageBitmap(trophie_item.getImage()); //nog geen foto
        
        return row;
    }
    


    public List<Trophie> getItemList() {
        return data;
    }
 
    public void setItemList(List<Trophie>  itemList) {
        this.data = itemList;
    }
	@Override
	public void clear() {
		super.clear();
	}
}