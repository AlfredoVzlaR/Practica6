package mx.edu.itson

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import mx.edu.itson.R.id.iv_pelicula_imagen

class Catalogo : AppCompatActivity() {

    var adapter: PeliculaAdapter? = null
    var peliculas = ArrayList<Pelicula>()
    val gridView: GridView = findViewById(R.id.gridview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)
        cargarPeliculas()

        adapter = PeliculaAdapter(peliculas,this)
        gridView.adapter = adapter
    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("6 big hero",R.drawable.bighero6,R.drawable.headerbighero6,"When a devastating event befalls the city of San Fransokyo and catapults Hiro into the\n" +
                "midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go\n" +
                "Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to\n" +
                "uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called\n" +
                "&quot;Big Hero 6.&quot"))
        peliculas.add(Pelicula("1917",R.drawable.war,R.drawable.warheader,"British trenches somewhere in France. World war has been going on for the third year,\n" +
                "heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly,\n" +
                "sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two\n" +
                "young soldiers, Blake and Schofield, are summoned to the general, who instructs them to\n" +
                "send an important message to Colonel MacKenzie in the Second Devonshire Battalion,\n" +
                "whose telephone connection was cut off by the enemy."))
        peliculas.add(Pelicula("Leap year",R.drawable.leapyear,R.drawable.leapyearheader,"A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish\n" +
                "tradition which occurs every time the date February 29 rolls around, faces a major setback\n" +
                "when bad weather threatens to derail her planned trip to Dublin. With the help of an\n" +
                "innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula("Men in black",R.drawable.mib,R.drawable.mibheader,"Based off of the comic book. Unbeknownst to other people, there is a private agency code\n" +
                "named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then,\n" +
                "one of the agency&#39;s finest men only going by the name &quot;K&quot; (Tommy Lee Jones) , is\n" +
                "recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of\n" +
                "the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of\n" +
                "the &quot;Bug&quot; race. He takes the body of a farmer (Vincent D&#39;Onofrio) and heads to New York.\n" +
                "He is searching for a super energy source called &quot;The Galaxy&quot;. Now, Agents J and K must\n" +
                "stop the bug before it can escape with the galaxy."))
        peliculas.add(Pelicula("Toy Story",R.drawable.toystory,R.drawable.toystoryheader,
                "Toy Story is about the &#39;secret life of toys&#39; when people are not around. When Buzz\n" +
                        "Lightyear, a space-ranger, takes Woody&#39;s place as Andy&#39;s favorite toy, Woody doesn&#39;t like\n" +
                        "the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and\n" +
                        "Woody is accused by all the other toys of having killed him. He has to go out of the house\n" +
                        "to look for him so that they can both return to Andys room. But while on the outside they\n" +
                        "get into all kind of trouble while trying to get home."))
    }
    class PeliculaAdapter: BaseAdapter{
        var peliculas = ArrayList<Pelicula>()
        var context: Context?=null

        constructor(peliculas:ArrayList<Pelicula>,context:Context?):super(){
            this.peliculas=peliculas
            this.context = context
        }

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        @SuppressLint("MissingInflatedId")
        override fun getView(p0: Int, p1:View?, p2:ViewGroup?): View {
            var pelicula = peliculas[p0]
            var inflator = LayoutInflater.from(context)
            var vista = inflator.inflate(R.layout.pelicula,null)

            var imagen = vista.findViewById(R.id.iv_pelicula_imagen) as ImageView
            var nombre = vista.findViewById(R.id.tv_nombre_pelicula) as TextView
            var descripcion = vista.findViewById(R.id.tv_pelicula_desc) as TextView


            imagen.setImageResource(pelicula.image)
            nombre.setText(pelicula.titulo)
            descripcion.setText(pelicula.sinopsis)


            return vista
        }
    }
}