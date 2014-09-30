package com.aidilab.airbus.fragment.shopping;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aidilab.airbus.R;
/**
 * A fragment representing a single Product detail screen. This fragment is
 * either contained in a {@link ProductListActivity} in two-pane mode (on
 * tablets) or a {@link ProductDetailActivity} on handsets.
 */
public class ProductDetailFragment extends Fragment {

	public ProductDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_shopping_detail,
				container, false);

		String categoria = getArguments().getString("categoria");
	    String prodotto = getArguments().getString("prodotto");
	    
	    ImageView image = (ImageView) rootView.findViewById(R.id.product_imageView);
	    TextView productName = (TextView) rootView.findViewById(R.id.product_name);
	    TextView productDetail = (TextView) rootView.findViewById(R.id.product_detail);
	    TextView productPrice = (TextView) rootView.findViewById(R.id.product_price);
	    
	    if(prodotto.equals("CK One")) {
	    	image.setImageResource(R.drawable.ckone);
	    	productName.setText(prodotto);
	    	productDetail.setText("CK One è un profumo della fashion house statunitense Calvin Klein." +"\n" +
	    			"Sebbene non sia stato il primo, cK One è sicuramente il profumo che ha reso popolari le fragranze Unisex.");
	    	productPrice.setText("€ 65");
	    } else if (prodotto.equals("Egoiste")) {
	    	image.setImageResource(R.drawable.egoist);
	    	productName.setText(prodotto);
	    	productDetail.setText("Égoïste è un profumo, della casa di moda Chanel. In seguito la sua produzione è stata affiancata da Égoïste Platinum." +"\n" +
	    			"Si tratta di un profumo da uomo, immesso nel mercato nel 1990, di genere boisé-floreale muschiato. " +"\n" +
	    			"Il nome Egoïste è stato selezionato come omaggio a quello che, secondo le donne, è il difetto principale degli uomini.");
	    	productPrice.setText("€ 80");
	    } else if (prodotto.equals("Light Blue")) {
	    	image.setImageResource(R.drawable.dglblue);
	    	productName.setText(prodotto);
	    	productDetail.setText("Light Blue è un profumo, della casa di moda Dolce & Gabbana." +"\n" +
	    			"Light Blue pour Femme viene lanciato sul mercato nel 2001, subito dopo il classico Dolce & Gabbana Parfum, ed ispirato alle atmosfere del Mar Mediterraneo," +"\n" +
	    			"secondo quanto dichiara la campagna pubblicitaria.");
	    	productPrice.setText("€ 75");
	    } else if (prodotto.equals("Only the Brave")) {
	    	image.setImageResource(R.drawable.onlybrave);
	    	productName.setText(prodotto);
	    	productDetail.setText("Only the Brave è una fragranza maschile creata nel uscita tra marzo e maggio del 2009, prodotta dall'azienda italiana Diesel in collaborazione con la IFF e L'Oréal." +"\n" +
	    			"Traendo il nome dal motto principio dell'azienda, che dà il nome anche alla holding di Renzo Rosso, Only The Brave si ispira al suo fondatore," +"\n" +
	    			"ed al tatuaggio delle sue iniziali che si è fatto incidere sulle nocche per il suo cinquantesimo compleanno." +"\n" +
	    			"La fragranza è dedicata al coraggio, alla fiducia in sé stessi e nelle proprie scelte.");
	    	productPrice.setText("€ 70");
	    } else if (prodotto.equals("Swatch")) {
	    	image.setImageResource(R.drawable.swatch);
	    	productName.setText(prodotto + " Scuba");
	    	productDetail.setText("Swatch è una marca di orologi di proprietà di The Swatch Group, società svizzera." +"\n" +
	    			"Swatch fu pensato in origine per ridare vita alla presenza svizzera sul mercato dell'orologeria, presenza andata scemando con la crescita aggressiva" +"\n" +
	    			"delle società giapponesi negli anni sessanta e anni settanta del Novecento.");
	    	productPrice.setText("€ 40");
	    } else if (prodotto.equals("Chronotech")) {
	    	image.setImageResource(R.drawable.chronotech);
	    	productName.setText(prodotto);
	    	productDetail.setText("Sinergia tra cassa e vetro. Geometrie variabili che danno vita ad una fusione cassa/vetro perfetta," +"\n" +
	    			"generando una sinergia di forme e una nuova percezione di lucentezza. Orologi sportivi per chi ama uno stile grintoso e si riconosce nel design di una linea audace e dinamica.");
	    	productPrice.setText("€ 70");
	    } else if (prodotto.equals("Moto360")) {
	    	image.setImageResource(R.drawable.moto360);
	    	productName.setText(prodotto);
	    	productDetail.setText("Moto 360 è uno smartwatch basato su Android Wear. È stato annunciato da Motorola Inc. il 18 marzo 2014 come come uno dei dispositivi di lancio per Android Wear," +"\n" +
	    			"una versione modificata di Android progettata specificamente per smartwatch e altri dispositivi indossabili. Una versione finale del dispositivo è stata esposta al Google I/O 2014. Durante l'IFA," +"\n" +
	    			"la kermesse berlinese sulla tecnologia, Moto 360 è stato presentato ufficialmente al mercato europeo. Moto 360 sarà disponibile durante il mese di ottobre.");
	    	productPrice.setText("€ 249");
	    } else if (prodotto.equals("Gucci")) {
	    	image.setImageResource(R.drawable.gucci_bag);
	    	productName.setText(prodotto);
	    	productDetail.setText("Gucci è una casa di moda italiana attiva nei settori di alta moda e articoli di lusso che fa parte della Gucci Group, divisione della holding francese Kering. È stata fondata da Guccio Gucci nel 1921 a Firenze." +"\n" +
	    			"Nel 2006 Gucci ha fatturato 7,6 miliardi di euro nel mondo diventando la seconda casa di moda più venduta dopo Louis Vuitton. È tutt'oggi uno dei marchi di moda più famosi d'Italia e uno dei più rinomati e importanti a livello internazionale," +"\n" +
	    			"con circa 300 store ufficiali aperti in tutto il mondo.");
	    	productPrice.setText("€ 350");
	    } else if (prodotto.equals("Alviero Martini")) {
	    	image.setImageResource(R.drawable.alviero_martini);
	    	productName.setText(prodotto);
	    	productDetail.setText("Alviero Martini nasce a Cuneo, dove compie i suoi studi artistici concludendoli con un corso di specializzazione come vetrinista-allestitore." +"\n" + 
	    			"All'età di quattordici anni impara a tagliare e cucire, diventando negli anni successivi costumista, oltre che attore in una compagnia teatrale. Nel 1976 recita nell'opera Affabulazione" +"\n" + 
	    			"di Pier Paolo Pasolini, al fianco di Vittorio Gassman.");
	    	productPrice.setText("€ 290");
	    } else if (prodotto.equals("Liu Jo")) {
	    	image.setImageResource(R.drawable.luijo);
	    	productName.setText(prodotto);
	    	productDetail.setText("Liu Jo S.p.A. è una azienda di abbigliamento italiana fondata a Carpi, in provincia di Modena nel 1995 dai fratelli Vannis e Marco Marchi." +"\n" +
	    			"Nata come azienda tessile specializzata nella lavorazione della lana[2], con il tempo la produzione di Liu Jo si è espansa all'abbigliamento pret-a-porter donna, uomo e bimbo, agli accessori, alle scarpe ed ai costumi da bagno," +"\n" + 
	    			"specializzando i vari prodotti in differenti linee");
	    	productPrice.setText("€ 249");
	    }
	    
		return rootView;
	}
}
