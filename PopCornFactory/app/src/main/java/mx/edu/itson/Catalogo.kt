package mx.edu.itson

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Catalogo : AppCompatActivity() {
    var adapter: PeliculaAdapter? = null
    var peliculas=ArrayList<Pelicula>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)
        val gridview: GridView = findViewById(R.id.gridview)

        cargarPeliculas()
        adapter=PeliculaAdapter(this,peliculas)
        gridview.adapter = adapter

    }

    fun cargarPeliculas(){
        peliculas.add(Pelicula("Big Hero 6",R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called ‘Big Hero 6.’"))
        peliculas.add(Pelicula("Inception",R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))
        peliculas.add(Pelicula("Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."))
        peliculas.add(Pelicula("Bones", R.drawable.bones, R.drawable.bonesheader, "Forensic anthropologist Dr Temperance 'Bones' Brennan and FBI Agent Seeley Booth form an unlikely alliance to solve cases by examining the remains of victims."))
        peliculas.add(Pelicula("Dr House", R.drawable.drhouse, R.drawable.drwhoheader, "Dr House, a medical genius, and his team get together to solve puzzling cases of patients with bizarre illnesses. In the process, they often end up flouting the hospital's administrative rules."))
        peliculas.add(Pelicula("Dr Who", R.drawable.drwho, R.drawable.drwhoheader,"`Doctor Who' is a classic science-fiction programme with a cult following. The Doctor is called a `Time Lord', a time-travelling scientist from a far off planet, who travels through time and space in a shop known by the acronym TARDIS."))
        peliculas.add(Pelicula("Frieds", R.drawable.friends, R.drawable.friendsheader, "Follow the lives of six reckless adults living in Manhattan, as they indulge in adventures which make their lives both troublesome and happening."))
        peliculas.add(Pelicula("Men in Black", R.drawable.mib, R.drawable.mibheader, "Men in Black is a series of American science fiction action comedy films directed by Barry Sonnenfeld, and based on the Malibu / Marvel comic book series The Men in Black by Lowell Cunningham, which was itself based on the conspiracy theory."))
        peliculas.add(Pelicula("SmallVille", R.drawable.smallville, R.drawable.smallvilleheader, "An interpretation of the Superman story features young Clark Kent coming to grips with his emerging superpowers. He must hide his abilities from his friends, including Lana Lang, the girl of his dreams, and Lex Luthor, who will one day become Superman's nemesis."))
        peliculas.add(Pelicula("Suits", R.drawable.suits, R.drawable.suitsheader, "Mike Ross, a talented young college dropout, is hired as an associate by Harvey Specter, one of New York's best lawyers. They must handle cases while keeping Mike's qualifications a secret."))
        peliculas.add(Pelicula("1917", R.drawable.war, R.drawable.warheader, "Two soldiers, assigned the task of delivering a critical message to another battalion, risk their lives for the job in order to prevent them from stepping right into a deadly ambush."))
    }

    class PeliculaAdapter:  BaseAdapter {

        var productos = ArrayList<Pelicula>()
        var contexto: Context? =null

        constructor(contexto: Context, pelicula: ArrayList<Pelicula>){
            this.productos = pelicula
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(p0: Int): Any {
            return productos[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var prod = productos[p0]
            var inflator=contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater
            var vista=inflator.inflate(R.layout.pelicula,null)

            var imagen = vista.findViewById(R.id.iv_pelicula) as ImageView
            var nombre = vista.findViewById(R.id.iv_titulo) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.titulo)

            imagen.setOnClickListener(){
                val intento = Intent(contexto,Detalle_pelicula::class.java)
                intento.putExtra("titulo",prod.titulo)
                intento.putExtra("imagen",prod.image)
                intento.putExtra("header",prod.header)
                intento.putExtra("sinopsis",prod.sinopsis)
                contexto!!.startActivity(intento)
            }
            return vista
        }

    }
}