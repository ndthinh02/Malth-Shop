package AdapterPhone;

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

import org.jetbrains.annotations.NotNull;

import java.util.List;

import ModelPhone.Product;

public class RecyclerViewPhoneAdapter extends RecyclerView.Adapter<RecyclerViewPhoneAdapter.PhoneViewHolder> {
    private Context context;
    private List<Product> list;


    public RecyclerViewPhoneAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_phone, parent, false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PhoneViewHolder holder, int position) {
        Product product=list.get(position);
        holder.tvNamePhone.setText(product.getProductName());
        holder.tvPrice.setText(product.getPrice()+"");
        if (product.getStatus()==0){
            holder.tvStatusPhone.setText("Còn hàng");
        }
        if (product.getStatus()!=0){
            holder.tvStatusPhone.setText("Hết hàng");
        }
        Picasso.get().load(product.getPicture())
                .placeholder(R.drawable.ic_baseline_home_24)
                .error(R.drawable.ic_baseline_error_24)
                .into(holder.imgPhone);
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }


    public class PhoneViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPhone;
        private TextView tvNamePhone;
        private TextView tvPrice;
        private TextView tvStatusPhone;
        public PhoneViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imgPhone = itemView.findViewById(R.id.img_phone);
            tvNamePhone = itemView.findViewById(R.id.tv_namePhone);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvStatusPhone = itemView.findViewById(R.id.tv_statusPhone);
        }
    }
}
