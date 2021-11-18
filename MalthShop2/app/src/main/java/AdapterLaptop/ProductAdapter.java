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

import ModelLaptop.Product;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> mListProduct;
        String img = "https://img.idesign.vn/2018/10/23/id-loading-1.gif";
    public ProductAdapter(Context context, List<Product> mListProduct) {
        this.context = context;
        this.mListProduct = mListProduct;
    }

    @NonNull

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_rv_laptop_new, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mListProduct.get(position);

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtPriceLaptopNew.setText(decimalFormat.format(product.getPrice())+"");
        holder.txtNameLaptopNew.setText(product.getProductName());
        Picasso.get().load(product.getImageProduct())
                .placeholder(R.drawable.laptop)
                .error(R.drawable.ic_home)
                .into(holder.imgLaptopNew);
//        Glide.with(context).load(img).into(holder.imgLaptop);

    }

    @Override
    public int getItemCount() {
        return mListProduct.size();
    }



    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameLaptopNew;
        private TextView txtPriceLaptopNew;
        private ImageView imgLaptopNew;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNameLaptopNew = (TextView) itemView.findViewById(R.id.txtNameLaptopNew);
            txtPriceLaptopNew = (TextView) itemView.findViewById(R.id.txtPriceLaptopNew);
            imgLaptopNew = (ImageView) itemView.findViewById(R.id.imgLaptopNew);
        }
    }
}
