package AdapterLaptop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malthshop.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import ModelLaptop.Mouse;

public class MouseAdapter extends RecyclerView.Adapter<MouseAdapter.MouseViewHolder> {
    private Context context;
    private List<Mouse> mListMouse;

    public MouseAdapter(Context context, List<Mouse> mListMouse) {
        this.context = context;
        this.mListMouse = mListMouse;
    }
    // Thinh dep trai ne Siuuuuu

    @NonNull

    @Override
    public MouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_rv_mouse, parent, false);
        return new MouseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MouseViewHolder holder, int position) {
        Mouse product = mListMouse.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtPriceMouse.setText(decimalFormat.format(product.getMousePrice())+"");
        holder.txtNameMouse.setText(product.getMouseName());
        Picasso.get().load(product.getMouseImage())
                .placeholder(R.drawable.laptop)
                .error(R.drawable.ic_home)
                .into(holder.imgMouse);

    }

    @Override
    public int getItemCount() {
        return mListMouse.size();
    }



    public class MouseViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameMouse;
        private TextView txtPriceMouse;
        private ImageView imgMouse;

        public MouseViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameMouse = (TextView) itemView.findViewById(R.id.txtNameMouse);
            txtPriceMouse = (TextView) itemView.findViewById(R.id.txtPriceMouse);
            imgMouse = (ImageView) itemView.findViewById(R.id.imgMouse);
        }
    }
}
