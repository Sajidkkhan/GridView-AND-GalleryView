package skk.simple.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
	private Context context;
	private int[] rankImages = { R.drawable.fieldmartial, R.drawable.general,
			R.drawable.lieutenantgeneral, R.drawable.majorgeneral,
			R.drawable.brigadier, R.drawable.colonel, R.drawable.ltcolonel,
			R.drawable.major, R.drawable.captain, R.drawable.lieutenant,
			R.drawable.secondlieutenant };
	private final String[] ranks = { "Field marshal (5-Star)",
			"General (4-Star)", "Lieutenant General (3-Star)",
			"Major General (2-Star)", "Brigadier (1-Star)", "Colonel",
			"Lieutenant Colonel", "Major", "Captain", "Lieutenant",
			"2nd Lieutenant" };

	public GridAdapter(Context context) {
		this.context = context;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;
		TextView textView = null;
		ImageView imageView = null;

		gridView = new View(context);

		// get layout from griditem.xml
		gridView = inflater.inflate(R.layout.griditem, null);

		// set value into textview
		textView = (TextView) gridView.findViewById(R.id.grid_item_label);

		// set image based on selected text
		imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);

		textView.setText(ranks[position]);
		imageView.setImageResource(rankImages[position]);
		return gridView;
	}

	@Override
	public int getCount() {
		return ranks.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

}