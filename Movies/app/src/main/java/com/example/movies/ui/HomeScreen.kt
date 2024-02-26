package com.example.movies.ui


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movies.R


data class Movie(val title: String, val year: Int, val poster: String)
var movies = listOf(
    Movie(title="Iron Man", year=2008, poster="https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_SX300.jpg"),
    Movie(title="The Incredible Hulk", year=2008, poster="https://m.media-amazon.com/images/M/MV5BMTUyNzk3MjA1OF5BMl5BanBnXkFtZTcwMTE1Njg2MQ@@._V1_SX300.jpg"),
    Movie(title="Iron Man 2", year=2010, poster="https://m.media-amazon.com/images/M/MV5BZGVkNDAyM2EtYzYxYy00ZWUxLTgwMjgtY2VmODE5OTk3N2M5XkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg"),
    Movie(title="Thor", year=2011, poster="https://m.media-amazon.com/images/M/MV5BOGE4NzU1YTAtNzA3Mi00ZTA2LTg2YmYtMDJmMThiMjlkYjg2XkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg"),
    Movie(title="Captain America: The First Avenger", year=2011, poster="https://m.media-amazon.com/images/M/MV5BNzAxMjg0NjYtNjNlOS00NTdlLThkMGEtMjAwYjk3NmNkOGFhXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg"),
    Movie(title="The Avengers", year=2012, poster="https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg"),
    Movie(title="Thor: The Dark World", year=2013, poster="https://m.media-amazon.com/images/M/MV5BMTQyNzAwOTUxOF5BMl5BanBnXkFtZTcwMTE0OTc5OQ@@._V1_SX300.jpg"),
    Movie(title="Captain America: The Winter Soldier", year=2014, poster="https://m.media-amazon.com/images/M/MV5BYzMyN2I0NjMtYmZhZS00MWJkLWE1MTktNGM2ZDhmNDE1ZDc0XkEyXkFqcGdeQXVyNDg2NzE0MjE@._V1_SX300.jpg"),
    Movie(title="Guardians of the Galaxy", year=2014, poster="https://m.media-amazon.com/images/M/MV5BNDIzMTk4NDYtMjg5OS00ZGI0LWJhZDYtMzdmZGY1YWU5ZGNkXkEyXkFqcGdeQXVyMTI5NzUyMTIz._V1_SX300.jpg"),
    Movie(title="Avengers: Age of Ultron", year=2015, poster="https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg"),
    Movie(title="Ant-Man", year=2015, poster="https://m.media-amazon.com/images/M/MV5BMjM2NTQ5Mzc2M15BMl5BanBnXkFtZTgwNTcxMDI2NTE@._V1_SX300.jpg")
)

@Composable
fun homeScreen(
    movieNestedList: List<List<Movie>>,
    modifier: Modifier = Modifier
) {
    LazyColumn() {
        items(movieNestedList) {
            moviesRow(movieList = it)
        }
    }
}

@Composable
fun moviesRow(
    movieList: List<Movie>,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    LazyRow(
        contentPadding = PaddingValues(4.dp)
    ) {
        items(movieList) { movie ->
            movieCard(
                movie = movie
            )
        }
    }
}

@Composable
fun movieCard(
    movie: Movie,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(movie.poster) // image source URL
                .crossfade(true)
                .build(),
            contentDescription = "Movie Poster",
            contentScale = ContentScale.FillWidth,
            error = painterResource(id = R.drawable.ic_broken_image),
            placeholder = painterResource(id = R.drawable.sample),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = movie.title, // title of the movie
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
//            color = Color.White,
            maxLines = 1,
            softWrap = false,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .width(100.dp)
                .padding(5.dp, 0.dp, 0.dp, 0.dp)
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun movieCardPreview() {
//    movieCard(movies[0])
//}

@Preview(showBackground = true)
@Composable
fun movieRowPreview() {
    moviesRow(movies)
}
