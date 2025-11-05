// TODO : FIX IDENTIFIER NOT BEING RETRIEVED


@file:OptIn(ExperimentalFoundationApi::class)

package com.example.ocdworld


import android.content.Context

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ocdworld.ui.theme.OcdworldTheme
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import androidx.compose.foundation.background
//import android.graphics.Color  // ✅ Jetpack Compose Color
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.ExperimentalFoundationApi
import android.media.MediaPlayer
import com.example.ocdworld.R
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.auth.auth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import io.github.jan.supabase.postgrest.from

// import io.github.jan.supabase.SupabaseClientBuilder

import io.github.jan.supabase.postgrest.Postgrest
import android.widget.Toast


import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import io.github.jan.supabase.createSupabaseClient

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.content.SharedPreferences
import io.ktor.client.request.*
import android.util.Log
import io.github.jan.supabase.auth.Auth
import io.ktor.client.call.*
import java.security.SecureRandom
import java.util.Base64
import io.github.jan.supabase.postgrest.query.*
import io.ktor.client.plugins.*

import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
//import io.ktor.client.engine.cio.*
import io.ktor.client.request.patch
import io.ktor.http.contentType
import io.ktor.http.ContentType
import io.ktor.client.request.setBody
//import io.ktor.client.request.forms.TextContent
import io.ktor.client.HttpClient
import io.ktor.client.statement.HttpResponse
import io.ktor.client.engine.okhttp.*
import com.example.ocdworld.PdfDocumentAdapter

import android.print.PrintManager

import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintDocumentInfo
import android.print.PageRange

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

import android.graphics.Bitmap
import android.graphics.pdf.PdfRenderer
// import android.os.ParcelFileDescriptor
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.withContext
//import java.time.Instant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
// import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import io.github.jan.supabase.createSupabaseClient    // to create the Supabase client
// for installing the Auth module
import io.github.jan.supabase.auth.providers.builtin.Email  // for the Email auth provider
import io.github.jan.supabase.auth.user.UserSession   // for the UserSession data class
//import io.github.jan.supabase.auth.sessionManager
//import io.github.jan.supabase.auth.providers.Email
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import kotlinx.serialization.json.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import io.ktor.http.content.TextContent
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.CenterAlignedTopAppBar
import java.net.HttpURLConnection
import java.net.URL
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.io.BufferedWriter
import org.json.JSONObject
import org.json.JSONArray
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import kotlin.text.toIntOrNull
//import io.github.jan.supabase.postgrest.rpc.match
// io.ktor.client.engine.cio.*
import androidx.compose.foundation.BorderStroke
import kotlinx.coroutines.delay
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlinx.serialization.SerialName

import androidx.compose.material.icons.filled.ArrowDropDown

import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults

import kotlinx.datetime.Clock

import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.result.PostgrestResult


import java.time.LocalDate
import java.time.YearMonth

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme

import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward

import androidx.compose.foundation.border














data class NewUser(
    val id: String, val name: String, val email: String, val identifier: String
)

@Composable
fun ModernRaisedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true // ✅ New parameter
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .padding(vertical = 8.dp),
        enabled = enabled, // ✅ Apply it here
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFAFAF5), // Soft off-white
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFDDDDDD)), // Soft border
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 6.dp
        )
    ) {
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold)
        )
    }
}

@Composable
fun MessageCard(name: String, preview: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(name, style = MaterialTheme.typography.titleMedium)
            Text(preview, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


@Serializable
data class Session(
    val id: Int,
    val client_name: String,
    val timestamp: Long,
    val session_type: String,
    val notes: String,
    val client_identifier: String,
    val therapist_id: String
)


@Serializable
data class MessagePayload(
    val sender_id: String,
    val recipient_id: String,
    val content: String,
    val timestamp: String,
    val sender_role: String
)



@Serializable
data class EntryUpload(
    val obsession: String,
    val compulsion: String,
    val times: Int,
    val identifier: String,
    val user_id: String
)

data class TherapySession(
    // val id: Int,
    //   val client_identifier: String,
    // val therapist_identifier: String,
    //val session_info_type: String,
    // val session_info_time: String
    val clientName: String, val timestamp: Long, val sessionType: String, val notes: String
)


@Serializable
data class Entry(
    val id: Int, // ← add this
    val obsession: String,
    val compulsion: String,
    val times: Int,
    val user_id: String? = null,
    val identifier: String
)

@Serializable
data class Message(
    val id: String,
    val sender_id: String,
    val recipient_id: String,
    val content: String?,  // make nullable
    val sender_role: String?,
    val timestamp: String,
    val status: String? = "pending" // ✅ added this
)

@Serializable
data class Relationship(
    val id: String,
    @SerialName("therapist_id") val therapistId: String,
    @SerialName("client_id") val clientId: String,
    val status: String,
    @SerialName("created_at") val createdAt: String,
    @SerialName("therapist_name") val therapistName: String? = null, // ✅ nullable
    @SerialName("client_name") val clientName: String? = null        // ✅ nullable
)





suspend fun fetchTherapistMessages(therapistId: String): List<Message> {
    return try {
        val client = HttpClient(OkHttp)
        val response: String = client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/messages") {
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
            }
            parameter("receipient_id", "eq.$therapistId")
            parameter("receiver_role", "eq.therapist")
            parameter("order", "timestamp.desc")
        }.bodyAsText()

        Json.decodeFromString(response)
    } catch (e: Exception) {
        println("❌ Failed to fetch messages: ${e.message}")
        emptyList()
    }
}


fun generateUserId(): String {
    val bytes = ByteArray(16) // 128 bits
    SecureRandom().nextBytes(bytes)
    return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes)
}

//fun sendTestData(supabase: SupabaseClient) {
//    val newEntry = Entry(
//      obsession = "Test Entry",
//    compulsion = "This is a test entry from the app.",
//  times = 8
//)

//CoroutineScope(Dispatchers.IO).launch {
//try {
//      supabase.from("entries").insert(newEntry)
//  println("✅ Data inserted successfully!")
//} catch (e: Exception) {
//      println("❌ Failed to insert data: ${e.message}")
//    }
//  }
//}

suspend fun checkUserByEmail(httpClient: HttpClient, email: String): Boolean {
    return try {
        val response: HttpResponse =
            httpClient.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/users") {
                headers {
                    append(
                        "apikey",
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                    )
                    append(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                    )
                    append("Accept", "application/json")
                }
                parameter("email", "eq.$email")
            }

        val responseBody = response.body<String>()
        println("Raw response: $responseBody")
        responseBody.contains(email)
    } catch (e: Exception) {
        println("❌ Error checking user: ${e.message}")
        false
    }
}


fun createUser(supabase: SupabaseClient, identifier: String, email: String) {
    val userId = generateUserId()
    val newUser = mapOf(
        "identifier" to userId, "email" to email
    )

    CoroutineScope(Dispatchers.IO).launch {
        try {
            supabase.from("users").insert(newUser)
            println("✅ User inserted successfully!")
        } catch (e: Exception) {
            println("❌ Failed to insert user: ${e.message}")
        }
    }
}

//cool
@Serializable
data class TherapistRequest(
    val id: String,
    @SerialName("therapist_id") val therapistId: String,
    @SerialName("client_id") val clientId: String,
    val status: String,
    @SerialName("created_at") val createdAt: String? = null, // ✅ Nullable
    @SerialName("therapist_name") val therapistName: String? = null,
    @SerialName("client_name") val clientName: String? = null
)




@Serializable
data class RelationshipUpload(
    val therapist_id: String,
    val client_id: String,
    val therapist_name: String,
    val client_name: String
)


@Serializable
data class Therapist(
    val id: String,
    val therapist_id: String,
    val years_practice: Int,
    val name: String,
    val qualifications: String,
    val therapy_type: String,
    val location: String,
    val fees: Int,
    val about: String,
    val updated_at: String
)

data class TherapistBio(
    //  val id: String? = null,
    val therapist_id: String,
    val years_practice: Int,
    val qualifications: String,
    val location: String,
    val fees: String,
    // val updated_at: String? = null,
    val about: String
)


@Serializable// Data class
data class ObsessionEntry(
    val id: Int, // ← NEW!

    val obsession: String,
    val compulsion: String,
    var times: Int,
    val identifier: String // ✅ Add this
)

@Serializable
data class SessionEntry(
    val client_id: String,
    val therapist_id: String,
    val session_date: String,  // ISO format: "2025-06-23T10:30:00Z"
    //val notes: String
)


@Serializable
data class ObsessionUpload(
    val obsession: String, val compulsion: String, val times: Int, val identifier: String
)

@Serializable
data class ERPTask(
    val id: Int,
    val user_id: String?,
    val title: String?,
    val description: String?,
    val date: String?,
    val category: String?,
    val status: String?,
    val linked_session_id: String?
)



sealed class Screen {
    object Main : Screen()
    object Coping : Screen()
    object Diary : Screen()
    object Chart : Screen()
    object SoundMenu : Screen()
    object Signup : Screen()
    object Login : Screen()
    object Pdf : Screen()
    object Loading : Screen()
    object ClientActionPlan : Screen()

    //  object TherapistHome : Screen()
    object Dashboard : Screen()
    object NewSession : Screen()
    object TherapistBio : Screen()
    object TherapistDashboard : Screen()
    object TherapistProfilePreview : Screen()
    object SearchTherapist : Screen()
    object OCDLog : Screen()
    object About : Screen()
    object TherapistInbox : Screen()
    object ClientDetails : Screen()  // ✅ ADD THIS
    object ActionPlan : Screen()



}


@Serializable
data class JournalEntryUpload(
    val identifier: String, val journalentry: String
)


suspend fun uploadSessionToSupabase(entry: SessionEntry) {
    withContext(Dispatchers.IO) {
        try {
            val url = URL("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/sessions")
            val connection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "POST"
            connection.setRequestProperty("apikey", BuildConfig.SUPABASE_ANON_KEY)
            connection.setRequestProperty(
                "Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}"
            )
            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("Prefer", "return=representation")
            connection.doOutput = true

            val requestBody = Json.encodeToString(entry)
            connection.outputStream.use { it.write(requestBody.toByteArray()) }

            val responseCode = connection.responseCode
            if (responseCode in 200..299) {
                println("✅ Session uploaded successfully.")
            } else {
                println("❌ Failed to upload session. Response code: $responseCode")
            }

            connection.disconnect()
        } catch (e: Exception) {
            println("❌ Error uploading session: ${e.message}")
        }
    }
}


@Composable
fun ClientDetailsScreen(
    client: Relationship,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(16.dp)
    ) {
        Text("Client Details", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(24.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Name: ${client.clientName}")
                Text("ID: ${client.clientId}")
                Text("Status: ${client.status}")
                Text("Linked Since: ${client.createdAt}")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = onBack) {
            Text("Back to Dashboard")
        }
    }
}




suspend fun sendMessageToUser(
    recipientId: String,
    content: String,
    therapistId: String,
    senderRole: String // "therapist" or "client"
) {
    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    try {
        val data = mapOf(
            "receiver_id" to recipientId,
            "sender_id" to therapistId,
            "content" to content,
            "status" to "sent",
            "sender_role" to senderRole,
            "timestamp" to Clock.System.now().toString()
        )

        val response = client.post("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/messages") {
            headers {
                append("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg")
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg")
                append("Content-Type", "application/json")
                append("Prefer", "return=minimal")
            }
            setBody(data)
        }

        if (response.status == HttpStatusCode.Created || response.status == HttpStatusCode.NoContent) {
            println("✅ Message successfully sent to $recipientId")
        } else {
            println("⚠️ Unexpected response: ${response.status}")
        }

    } catch (e: Exception) {
        println("❌ Error sending message: ${e.message}")
    } finally {
        client.close()
    }
}

suspend fun fetchPendingRequests(therapistId: String): List<TherapistRequest> {
    val url =
        "https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/therapist_requests?therapist_id=eq.$therapistId&status=eq.pending"

    val client = HttpClient(OkHttp)
    return try {
        val response: HttpResponse = client.get(url) {
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
            }
        }

        val responseBody = response.bodyAsText()

        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }.decodeFromString(responseBody)
    } catch (e: Exception) {
        println("❌ Failed to fetch therapist requests: ${e.localizedMessage}")
        emptyList()

    } finally {
        client.close()
    }
}


suspend fun fetchSessionsByClientId(clientId: String): List<Session> {
    val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    return try {
        val response: HttpResponse = client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/sessions") {
            headers {
                append("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
                append("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
            }
            parameter("client_identifier", "eq.$clientId")
            parameter("select", "*")
        }

        if (response.status.isSuccess()) {
            response.body()
        } else {
            println("❌ Supabase error: ${response.status}")
            emptyList()
        }
    } catch (e: Exception) {
        println("❌ Failed to fetch sessions: ${e.message}")
        emptyList()
    }
}


fun fetchTherapistBio(therapistId: String): JSONObject? {
    println("👀 Starting fetchTherapistBio with ID: $therapistId")
    return try {
        val fullUrl =
            "https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/therapist_bios?therapist_id=eq.$therapistId&order=updated_at.desc&limit=1"
        println("🌐 Constructed URL: $fullUrl")

        val url = URL(fullUrl)
        val conn = url.openConnection() as HttpURLConnection

        println("🔧 Setting headers...")
        conn.requestMethod = "GET"
        conn.setRequestProperty("apikey", BuildConfig.SUPABASE_ANON_KEY)
        conn.setRequestProperty("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
        conn.setRequestProperty("Content-Type", "application/json")

        println("📡 Sending request...")
        val responseCode = conn.responseCode
        println("📬 Response code: $responseCode")

        val responseText = if (responseCode in 200..299) {
            conn.inputStream.bufferedReader().readText()
        } else {
            val errorText = conn.errorStream?.bufferedReader()?.readText()
            println("❌ Server returned error: $errorText")
            return null
        }

        println("📦 Response body: $responseText")

        val jsonArray = JSONArray(responseText)
        return if (jsonArray.length() > 0) jsonArray.getJSONObject(0) else null

    } catch (e: Exception) {
        println("❌ Exception during fetchTherapistBio: ${e.message}")
        null
    }
}


suspend fun fetchSessionHistoryForClient(
    clientId: String,
    therapistId: String
): List<SessionEntry> {
    return withContext(Dispatchers.IO) {
        try {
            val client = HttpClient {
                install(ContentNegotiation) {
                    json()
                }
            }

            val response: HttpResponse = client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/sessions") {
                headers {
                    append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                    append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                }
                parameter("client_identifier", "eq.$clientId")
                parameter("therapist_id", "eq.$therapistId")
                parameter("order", "timestamp.desc")
            }

            if (response.status.value in 200..299) {
                val body = response.bodyAsText()
                Json.decodeFromString(body)
            } else {
                println("❌ Failed to fetch sessions: ${response.status}")
                emptyList()
            }
        } catch (e: Exception) {
            println("❌ Error fetching sessions: ${e.message}")
            emptyList()
        }
    }
}



suspend fun acceptTherapistRequest(
    requestId: String,
    therapistId: String,
    clientId: String,
    therapistName: String,
    clientName: String,
    refreshClients: () -> Unit
) {
    val client = HttpClient(OkHttp)

    try {
        // Step 1: Update request status to Accepted
        val updateResponse: HttpResponse = client.patch("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/therapist_requests?id=eq.$requestId") {
            contentType(ContentType.Application.Json)
            setBody("""{ "status": "Accepted" }""")
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                append("Prefer", "return=representation")
            }
        }
        println("✅ Request status updated: ${updateResponse.status}")

        // Step 2: Insert into relationships table
        val relationship = RelationshipUpload(
            therapist_id = therapistId,
            client_id = clientId,
            therapist_name = therapistName,
            client_name = clientName
        )
        val jsonBody = Json.encodeToString(relationship)

        val relationshipResponse: HttpResponse = client.post("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/relationships") {
            contentType(ContentType.Application.Json)
            setBody(jsonBody)
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                append("Prefer", "return=representation")
            }
        }
        println("✅ Relationship created: ${relationshipResponse.status}")

        // Step 3: Trigger refresh
        refreshClients()

    } catch (e: Exception) {
        println("❌ Error in acceptTherapistRequest: ${e.localizedMessage}")
    } finally {
        client.close()
    }
}




suspend fun denyTherapistRequest(requestId: String, onSuccess: () -> Unit) {
    val url = "https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/therapist_requests?id=eq.$requestId"

    val client = HttpClient(OkHttp)
    try {
        val response: HttpResponse = client.patch(url) {
            contentType(ContentType.Application.Json)
            setBody("""{"status": "Denied"}""")
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                append("Prefer", "return=representation")
            }
        }

        println("🛑 Denied request $requestId: ${response.status}")
        onSuccess()
    } catch (e: Exception) {
        println("❌ Error denying therapist request: ${e.localizedMessage}")
    }
}


@Composable
fun TherapistRequestListScreen(
    therapistId: String,
    requestList: List<TherapistRequest>,
    onRefreshRequests: () -> Unit,
    refreshClients: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()

    Column {
        Text("Pending Therapist Requests", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))

        requestList.forEach { request ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("Client: ${request.clientName}")
                    Text("Status: ${request.status}")

                    requestList.forEach { request: TherapistRequest ->
                        Row(modifier = Modifier.padding(top = 8.dp)) {
                            Button(onClick = {
                                coroutineScope.launch {
                                    acceptTherapistRequest(
                                        requestId = request.id,
                                        therapistId = therapistId,
                                        clientId = request.clientId ?: "",
                                        therapistName = request.therapistName ?: "",
                                        clientName = request.clientName ?: "",
                                        refreshClients = refreshClients
                                    )
                                    onRefreshRequests()
                                }
                            }) {
                                Text("Accept")
                            }
                        }



                        Spacer(modifier = Modifier.width(8.dp)) // space between buttons

                        Button(onClick = {
                            coroutineScope.launch {
                                denyTherapistRequest(request.id) {
                                    onRefreshRequests()
                                }
                            }
                        }, colors = ButtonDefaults.buttonColors(containerColor = Color.Red)) {
                            Text("Deny", color = Color.White)
                        }

                    }
                }
            }
        }
    }
}













suspend fun fetchMessagesForTherapist(therapistName: String): List<Message> {
    return try {
        val supabase = createSupabaseClient(
            supabaseUrl = "https://ituaxigakgytlknrjkzz.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
        ) {
            install(io.github.jan.supabase.postgrest.Postgrest)
        }

        // ✅ Use Columns.ALL instead of "*"
        val result: PostgrestResult = supabase
            .from("messages")
            .select(columns = Columns.ALL)

        // ✅ Decode into Message objects
        val messages = result.decodeList<Message>()

        // ✅ Filter for the therapist name
        val filtered = messages.filter {
            it.recipient_id.equals(therapistName, ignoreCase = true)
        }

        println("✅ ${filtered.size} messages matched therapist '$therapistName'")
        filtered
    } catch (e: Exception) {
        println("❌ Error fetching messages: ${e.message}")
        emptyList()
    }
}





@Composable
fun TherapistInboxScreen(
    therapistId: String,
    onBack: () -> Unit
) {
    var messages by remember { mutableStateOf<List<Message>>(emptyList()) }
    var selectedMessage by remember { mutableStateOf<Message?>(null) }
    var replyText by remember { mutableStateOf("") }
    var showReplyDialog by remember { mutableStateOf(false) }

    // ✅ Fetch messages when therapist opens inbox
    LaunchedEffect(therapistId) {
        println("📥 Fetching messages for therapistId: $therapistId")
        messages = fetchMessagesForTherapist(therapistId)
        println("📬 Messages fetched: ${messages.size}")
    }

    // ✅ Wrap in a Surface for proper theming
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "Therapist Inbox",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (messages.isEmpty()) {
                Text(
                    "No messages found.",
                    color = MaterialTheme.colorScheme.onBackground
                )
            } else {
                LazyColumn {
                    items(messages) { message ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surface
                            )
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(
                                    "📩 From: ${message.sender_id}",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    "💬 Message: ${message.content}",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    "⏰ At: ${message.timestamp}",
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    "🧠 Status: ${message.status ?: "pending"}",
                                    color = MaterialTheme.colorScheme.onSurface
                                )

                                Spacer(modifier = Modifier.height(8.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    // 🔹 Add buttons for Accept / Reply / Delete if needed
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onBack,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Back")
            }
        }
    }

    // 🔹 Optional: reply dialog placeholder
    if (showReplyDialog && selectedMessage != null) {
        AlertDialog(
            onDismissRequest = { showReplyDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    // Handle reply send here
                    showReplyDialog = false
                }) {
                    Text("Send")
                }
            },
            dismissButton = {
                TextButton(onClick = { showReplyDialog = false }) {
                    Text("Cancel")
                }
            },
            title = { Text("Reply to Message") },
            text = {
                OutlinedTextField(
                    value = replyText,
                    onValueChange = { replyText = it },
                    label = { Text("Type your reply...") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        )
    }
}


suspend fun updateMessageStatus(messageId: String, newStatus: String) {
    try {
        val supabase: SupabaseClient = createSupabaseClient(
            supabaseUrl = "https://ituaxigakgytlknrjkzz.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
        ) {
            install(io.github.jan.supabase.postgrest.Postgrest)
        }

        // ✅ This version includes a WHERE filter (eq)
        supabase
            .from("messages")
            .update(
                mapOf("status" to newStatus)
            ) {
                filter {
                    eq("id", messageId) // 👈 this is the WHERE clause
                }
            }

        println("✅ Message $messageId updated to status: $newStatus")
    } catch (e: Exception) {
        println("❌ Error updating message status: ${e.message}")
    }
}









suspend fun fetchClientsForTherapist(therapistId: String): List<Relationship> {
    val client = HttpClient(OkHttp)
    val url = "https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/relationships" +
            "?therapist_id=eq.$therapistId&client_id=not.is.null&status=eq.accepted&select=*"

    val response: String = client.get(url) {
        headers {
            append("apikey", BuildConfig.SUPABASE_ANON_KEY)
            append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
        }
    }.bodyAsText()

    println("📥 Filtered relationships: $response")

    return Json.decodeFromString(response)
}




@Composable
fun AboutScreen(onBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text("🧠 About This App", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "This app was created by someone who knows what it’s like to live with OCD.\n\n" +
                        "My name is Danial, and I built this to help track the obsessions and compulsions that once ruled my life. " +
                        "For years, I struggled with intrusive thoughts, exhausting rituals, and the fear that I was broken. " +
                        "What helped me was understanding my patterns — and then challenging them.\n\n" +
                        "This app is based on that same principle: awareness and action.\n\n" +
                        "With simple tools like obsession/compulsion logs, session tracking, counters, and journaling, " +
                        "you can start noticing your cycles — and slowly begin to break them. " +
                        "The features are designed to support CBT-based techniques and exposure practices. " +
                        "Every entry you make is a step toward clarity, control, and healing.\n\n" +
                        "This app doesn’t promise to cure OCD — but it’s here to support you every day. You’re not alone in this.\n\n" +
                        "Welcome to your progress.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}



fun uploadBioToSupabase(
    therapistId: String,
    yearsPractice: String,
    qualifications: String,
    location: String,
    fees: String,
    about: String


) {


    // 🟢 Add this debug line FIRST
    println("✔️ About variable going into JSON: '$about'")

    val json = JSONObject().apply {

        put("therapist_id", therapistId)
        put("years_practice", yearsPractice.toIntOrNull() ?: 0)
        put("qualifications", qualifications)
        put("location", location)
        put("fees", fees)
        put("about", about)


    }



    CoroutineScope(Dispatchers.IO).launch {
        try {
            val url =
                URL("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/therapist_bios?therapist_id=eq.$therapistId")
            val conn = url.openConnection() as HttpURLConnection
            conn.requestMethod = "PATCH"
            conn.setRequestProperty("apikey", BuildConfig.SUPABASE_ANON_KEY)
            conn.setRequestProperty("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
            conn.setRequestProperty("Content-Type", "application/json")
            conn.setRequestProperty("Prefer", "return=representation")
            conn.doOutput = true

            val outputWriter = BufferedWriter(OutputStreamWriter(conn.outputStream, "UTF-8"))
            outputWriter.write(json.toString())
            outputWriter.flush()
            outputWriter.close()

            val responseCode = conn.responseCode
            println("📤 Bio upload status: $responseCode")

            if (responseCode >= 200 && responseCode < 300) {
                val reader = BufferedReader(InputStreamReader(conn.inputStream))
                val response = reader.readText()
                println("✅ Upload success: $response")
                reader.close()
            } else {
                val errorReader = BufferedReader(InputStreamReader(conn.errorStream))
                val errorResponse = errorReader.readText()
                println("❌ Upload failed: $errorResponse")
                errorReader.close()
            }

            conn.disconnect()
        } catch (e: Exception) {
            println("❌ Exception: ${e.message}")
        }
    }
}







@Composable
fun FeatureCard(
    title: String, subtitle: String, onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(subtitle, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}


@Composable
fun SearchTherapistScreen(

    onBack: () -> Unit,
    supabase: SupabaseClient,
    modifier: Modifier = Modifier,


) {
    val context = LocalContext.current
    var selectedType by remember { mutableStateOf("CBT") }
    var fees by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var allTherapists by remember { mutableStateOf(listOf<Therapist>()) }

    // 🟢 Dialog state for message sending
    var showDialog by remember { mutableStateOf(false) }
    var messageText by remember { mutableStateOf("") }
    var selectedTherapist by remember { mutableStateOf<Therapist?>(null) }

    // Load therapists from Supabase
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            try {
                val client = HttpClient()
                val response: HttpResponse =
                    client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/therapist_bios") {
                        headers {
                            append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                            append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                            append("Content-Type", "application/json")
                        }
                        parameter("select", "*")
                    }
                val body = response.bodyAsText()
                allTherapists = Json { ignoreUnknownKeys = true }.decodeFromString(body)
            } catch (e: Exception) {
                println("❌ Error fetching therapists: ${e.message}")
            }
        }
    }

    val filteredTherapists = remember(selectedType, fees, location, allTherapists) {
        allTherapists.filter {
            it.qualifications.lowercase().contains(selectedType.lowercase()) &&
                    (location.isBlank() || it.location.lowercase().contains(location.lowercase())) &&
                    (fees.isBlank() || (it.fees.toString().toIntOrNull() ?: Int.MAX_VALUE) <= (fees.toIntOrNull() ?: Int.MAX_VALUE))
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text("Search for a Therapist", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Therapy Type")
            Box {
                OutlinedTextField(
                    value = selectedType,
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    trailingIcon = {
                        IconButton(onClick = { expanded = !expanded }) {
                            Icon(
                                imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                                contentDescription = "Dropdown"
                            )
                        }
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.background(MaterialTheme.colorScheme.surface)
                ) {
                    listOf("CBT", "EMDR", "ACT", "DBT").forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type) },
                            onClick = {
                                selectedType = type
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = fees,
                onValueChange = { fees = it },
                label = { Text("Max Fee (£)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Location") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Results", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            if (filteredTherapists.isEmpty()) {
                Text("No therapists found.")
            } else {
                filteredTherapists.forEach { therapist ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("Name: ${therapist.name}")
                            Text("Type: ${therapist.qualifications}")
                            Text("Location: ${therapist.location}")
                            Text("Fees: £${therapist.fees}")
                            Text("Years: ${therapist.years_practice}")
                            Text("About: ${therapist.about}")

                            Spacer(Modifier.height(8.dp))

                            // 🟢 Message Therapist Button
                            Button(
                                onClick = {
                                    selectedTherapist = therapist
                                    showDialog = true
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Message Therapist")
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("⬅ Back")
            }
        }

        // 🟢 Message Dialog appears here (after column)
        if (showDialog && selectedTherapist != null) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Message ${selectedTherapist!!.name}") },
                text = {
                    OutlinedTextField(
                        value = messageText,
                        onValueChange = { messageText = it },
                        label = { Text("Enter your message") },
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            if (messageText.isNotBlank()) {
                                CoroutineScope(Dispatchers.IO).launch {
                                    sendMessageToTherapist(
                                        context = context,
                                        supabase = supabase,
                                        therapistName = selectedTherapist!!.name,
                                        message = messageText
                                    )
                                }
                                showDialog = false
                                messageText = ""
                            }
                        }
                    ) {
                        Text("Send")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                }
            )
        }
    }
}



suspend fun sendMessageToTherapist(
    context: Context,
    supabase: SupabaseClient,
    therapistName: String,
    message: String
) {
    try {
        withContext(Dispatchers.IO) {
            // ✅ Get the sender_id (client’s ID) from SharedPreferences
            val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
            val senderId = prefs.getString("identifier", "") ?: ""

            if (senderId.isBlank()) {
                println("❌ Error: sender_id is blank.")
                return@withContext
            }

            val data = mapOf(
                "sender_id" to senderId,         // ✅ now included
                "recipient_id" to therapistName,  // or therapist_id if that's the column
                "content" to message,
                "status" to "pending",
                "sender_role" to "user",
                "timestamp" to Clock.System.now().toString()
            )

            supabase.from("messages").insert(data)
            println("✅ Message sent from $senderId to $therapistName")
        }
    } catch (e: Exception) {
        println("❌ Error sending message: ${e.message}")
    }
}



@Composable
fun TherapistProfilePreviewScreen(therapistId: String, onBack: () -> Unit) {
    var bio by remember { mutableStateOf<JSONObject?>(null) }

    LaunchedEffect(therapistId) {
        withContext(Dispatchers.IO) {
            println("👀 Loading therapist preview for: $therapistId")
            val result = fetchTherapistBio(therapistId)
            println("✅ Result from Supabase: $result")
            bio = result
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F4F4))
            .padding(WindowInsets.systemBars.asPaddingValues()) // ✅ Status bar fix
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Therapist Profile Preview",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Image(
                    painter = painterResource(id = R.drawable.placeholder),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(240.dp)
                        .align(Alignment.CenterHorizontally)
                )

                if (bio != null) {
                    val years = bio?.optString("years_practice") ?: ""
                    val qualifications = bio?.optString("qualifications") ?: ""
                    val location = bio?.optString("location") ?: ""
                    val fees = bio?.optString("fees") ?: ""
                    val about = bio?.optString("about") ?: ""

                    InfoRow("Years of Practice", years)
                    InfoRow("Qualifications", qualifications)
                    InfoRow("Location", location)
                    InfoRow("Fees", fees)
                    InfoRow("About", about)
                } else {
                    Text(
                        "No profile found. Please create or update your bio.",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        ModernRaisedButton(
            text = "⬅ Back",
            onClick = onBack,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}



suspend fun saveBioToSupabase(
    therapistId: String,
    years: String,
    qualifications: String,
    location: String,
    fees: String,
    about: String
) {
    val client = HttpClient()

    val payload = JSONObject().apply {
        put("therapist_id", therapistId)
        put("years_practice", years)
        put("qualifications", qualifications)
        put("location", location)
        put("fees", fees)
        put("about", about)
    }

    val response: HttpResponse = client.post(
        "https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/therapist_bio"
    ) {
        headers {
            append(HttpHeaders.Authorization, "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9zZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg")
            append("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9zZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg")
            append(HttpHeaders.ContentType, "application/json")
            append("Prefer", "resolution=merge-duplicates") // 👈 upsert mode (insert or update)
        }
        setBody(payload.toString())
    }

    if (response.status == HttpStatusCode.Created || response.status == HttpStatusCode.NoContent) {
        println("✅ Bio saved successfully for $therapistId")
    } else {
        println("❌ Failed to save bio. Response: ${response.status}")
    }

    client.close()
}


@Composable
fun TherapistBioScreen(
    therapistId: String,
    onSave: () -> Unit
) {
    var yearsState by remember { mutableStateOf("") }
    var qualificationsState by remember { mutableStateOf("") }
    var locationState by remember { mutableStateOf("") }
    var feesState by remember { mutableStateOf("") }
    var aboutState by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    // ✅ Fetch bio on load
    LaunchedEffect(therapistId) {
        println("📥 Fetching bio for therapistId: $therapistId")

        scope.launch {
            try {
                val bio = withContext(Dispatchers.IO) {
                    fetchTherapistBio(therapistId)
                }

                if (bio != null) {
                    println("✅ Got bio from Supabase: $bio")
                    yearsState = bio.opt("years_practice")?.toString() ?: ""
                    qualificationsState = bio.opt("qualifications")?.toString() ?: ""
                    locationState = bio.opt("location")?.toString() ?: ""
                    feesState = bio.opt("fees")?.toString() ?: ""
                    aboutState = bio.opt("about")?.toString() ?: ""
                } else {
                    println("❌ No bio found for therapistId: $therapistId")
                }
            } catch (e: Exception) {
                println("❌ Error fetching bio: ${e.message}")
            }
        }
    }

    // ✅ Wrap in Surface for theme-aware background
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                "Edit Your Bio",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            OutlinedTextField(
                value = yearsState,
                onValueChange = { yearsState = it },
                label = { Text("Years of Practice") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = qualificationsState,
                onValueChange = { qualificationsState = it },
                label = { Text("Qualifications") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = locationState,
                onValueChange = { locationState = it },
                label = { Text("Location") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = feesState,
                onValueChange = { feesState = it },
                label = { Text("Fees") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = aboutState,
                onValueChange = { aboutState = it },
                label = { Text("About You") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 4
            )

            Spacer(modifier = Modifier.height(16.dp))

            ModernRaisedButton(
                text = "💾 Save Bio",
                onClick = {
                    scope.launch(Dispatchers.IO) {    // 👈 run it in a coroutine
                        saveBioToSupabase(
                            therapistId = therapistId,
                            years = yearsState,
                            qualifications = qualificationsState,
                            location = locationState,
                            fees = feesState,
                            about = aboutState
                        )
                        withContext(Dispatchers.Main) {
                            onSave()   // 👈 return to UI thread if needed
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )


            Spacer(modifier = Modifier.height(8.dp))

            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}


@Composable
fun OutlookStyleCalendar(
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    var currentMonth by remember { mutableStateOf(YearMonth.now()) }
    val daysInMonth = currentMonth.lengthOfMonth()
    val firstDayOfWeek = currentMonth.atDay(1).dayOfWeek.value
    val dates = (1..daysInMonth).map { currentMonth.atDay(it) }

    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { currentMonth = currentMonth.minusMonths(1) }) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Prev")
            }
            Text(
                currentMonth.month.name.lowercase().replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.titleLarge
            )
            IconButton(onClick = { currentMonth = currentMonth.plusMonths(1) }) {
                Icon(Icons.Default.ArrowForward, contentDescription = "Next")
            }
        }

        LazyVerticalGrid(columns = GridCells.Fixed(7)) {
            items(firstDayOfWeek - 1) { Spacer(Modifier.height(48.dp)) }
            items(dates) { date ->
                val isSelected = date == selectedDate
                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isSelected) Color(0xFF1976D2) else Color.Transparent)
                        .clickable { onDateSelected(date) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = date.dayOfMonth.toString(),
                        color = if (isSelected) Color.White else Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(label: String, value: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Text(text = "$label:", style = MaterialTheme.typography.labelMedium)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}

data class OcdLogEntry(
    val id: Int,
    val obsession: String,
    val compulsion: String,
    val timestamp: String,
    val user_id: String
)


suspend fun fetchOcdLogsHttp(identifier: String): List<OcdLogEntry> {
    val client = HttpClient(OkHttp)

    return try {
        val response: HttpResponse = client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/ocd_logs") {
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                append("Accept", "application/json")
            }
            parameter("identifier", "eq.$identifier")  // ✅ changed from user_id
        }

        val responseBody = response.bodyAsText()

        val listType = object : TypeToken<List<OcdLogEntry>>() {}.type
        Gson().fromJson(responseBody, listType)

    } catch (e: Exception) {
        Log.e("FETCH_OCDLOG_ERROR", "❌ Failed to fetch OCD logs: ${e.message}")
        emptyList()
    }
}





@OptIn(ExperimentalMaterial3Api::class)



@Composable
fun NewSessionScreen(
    therapistId: String,
    acceptedClients: List<Relationship>,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)

    var selectedClient by remember { mutableStateOf<Relationship?>(null) }
    var sessionType by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }
    val timestamp = System.currentTimeMillis()

    var showHistory by remember { mutableStateOf(false) }
    var sessionHistory by remember { mutableStateOf<List<Session>>(emptyList()) }
    var expanded by remember { mutableStateOf(false) }
    val currentAcceptedClients by rememberUpdatedState(newValue = acceptedClients)

    // ✅ Wrap the entire screen in a Surface to avoid black background issues
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(WindowInsets.systemBars.asPaddingValues())
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Log New Session", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))

            // Client selection dropdown
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = !expanded
                        Log.d("DropdownDebug", "Expanded toggled to: $expanded")
                    }
                ) {
                    OutlinedTextField(
                        readOnly = true,
                        value = selectedClient?.clientName ?: "Select Client",
                        onValueChange = {},
                        label = { Text("Select Client") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                            .background(Color.White)
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = {
                            expanded = false
                            Log.d("DropdownDebug", "Dropdown dismissed")
                        },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxWidth()
                    ) {
                        currentAcceptedClients
                            .filter { !it.clientName.isNullOrBlank() }
                            .forEach { client ->
                                DropdownMenuItem(
                                    text = { Text(client.clientName ?: "Unknown") },
                                    onClick = {
                                        Log.d("DropdownDebug", "Selected client: ${client.clientName}")
                                        selectedClient = client
                                        expanded = false
                                        showHistory = false
                                        sessionHistory = emptyList()
                                    },
                                    modifier = Modifier.background(Color.White)
                                )
                            }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = sessionType,
                onValueChange = { sessionType = it },
                label = { Text("Session Type (e.g. CBT)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Notes") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            ModernRaisedButton(
                text = "💾 Save Session",
                onClick = {
                    val clientId = selectedClient?.clientId ?: return@ModernRaisedButton
                    val userId = prefs.getString("user_id", "") ?: ""
                    val authToken = prefs.getString("auth_token", "") ?: ""

                    val sessionData = buildJsonObject {
                        put("client_name", selectedClient?.clientName ?: "")
                        put("timestamp", timestamp)
                        put("session_type", sessionType)
                        put("notes", notes)
                        put("client_identifier", clientId)
                        put("therapist_id", userId)
                    }

                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val client = HttpClient {
                                install(ContentNegotiation) { json() }
                            }
                            println("📤 Sending session data: $sessionData")

                            val response = client.post("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/sessions") {
                                headers {
                                    append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                                    append("Authorization", "Bearer $authToken")
                                    append("Content-Type", "application/json")
                                    append("Prefer", "return=representation")
                                }
                                setBody(sessionData)
                            }

                            println("✅ Upload successful: ${response.status}")
                            withContext(Dispatchers.Main) { onBack() }

                        } catch (e: Exception) {
                            println("❌ Failed to upload session: ${e.message}")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            ModernRaisedButton(
                text = "🔍 View Therapy History",
                onClick = {
                    selectedClient?.clientId?.let { id ->
                        CoroutineScope(Dispatchers.IO).launch {
                            val results = fetchSessionsByClientId(id)
                            withContext(Dispatchers.Main) {
                                sessionHistory = results
                                showHistory = true
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                enabled = selectedClient != null
            )

            if (showHistory) {
                Text("Therapy History:", style = MaterialTheme.typography.titleMedium)
                sessionHistory.forEach { session ->
                    Card(modifier = Modifier.padding(vertical = 4.dp)) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("Date: ${session.timestamp}")
                            Text("Type: ${session.session_type}")
                            Text("Notes: ${session.notes}")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            ModernRaisedButton(
                text = "✖ Cancel",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}



// 🔑 Supabase constants
const val SUPABASE_URL = "https://ituaxigakgytlknrjkzz.supabase.co"
const val SUPABASE_API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"

// 🌐 Shared HttpClient (OkHttp to avoid header issues)
val httpClient = HttpClient(OkHttp)

// 🟢 Fetch all ERP tasks
suspend fun fetchERPTasksForDate(identifier: String, date: String): List<ERPTask> {
    val url = "$SUPABASE_URL/rest/v1/erp_tasks?select=*&user_id=eq.$identifier&date=eq.$date"

    val response = httpClient.get(url) {
        headers {
            append("apikey", SUPABASE_API_KEY)
            append("Authorization", "Bearer $SUPABASE_API_KEY")
            append(HttpHeaders.ContentType, "application/json")
            append(HttpHeaders.Accept, "application/json")
        }
    }

    val json = response.bodyAsText()

    return try {
        Json.decodeFromString(json)
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}


// 🟣 Insert a new ERP task
suspend fun addERPTask(
    userId: String,
    title: String,
    description: String,
    date: String,
    category: String = "General",
    status: String = "Pending"
): String {
    val jsonBody = JSONObject().apply {
        put("user_id", userId)
        put("title", title)
        put("description", description)
        put("date", date)
        put("category", category)
        put("status", status)
    }.toString()

    val response = httpClient.post("$SUPABASE_URL/rest/v1/erp_tasks") {
        headers {
            append("apikey", SUPABASE_API_KEY)
            append("Authorization", "Bearer $SUPABASE_API_KEY")
            append(HttpHeaders.ContentType, "application/json")
            append(HttpHeaders.Accept, "application/json")
        }
        setBody(jsonBody)
    }

    return response.bodyAsText()
}

// 🟠 Update an existing ERP task by ID
suspend fun updateERPTaskStatus(
    taskId: Int,
    newStatus: String
): String {
    val jsonBody = JSONObject().apply {
        put("status", newStatus)
    }.toString()

    val response = httpClient.patch("$SUPABASE_URL/rest/v1/erp_tasks?id=eq.$taskId") {
        headers {
            append("apikey", SUPABASE_API_KEY)
            append("Authorization", "Bearer $SUPABASE_API_KEY")
            append(HttpHeaders.ContentType, "application/json")
            append(HttpHeaders.Accept, "application/json")
        }
        setBody(jsonBody)
    }

    return response.bodyAsText()
}


suspend fun fetchTodaysERPTasks(identifier: String): List<ERPTask> {
    val today = LocalDate.now().toString()
    val url = "$SUPABASE_URL/rest/v1/erp_tasks?select=*&user_id=eq.$identifier&date=eq.$today"

    val response = httpClient.get(url) {
        headers {
            append("apikey", SUPABASE_API_KEY)
            append("Authorization", "Bearer $SUPABASE_API_KEY")
            append(HttpHeaders.ContentType, "application/json")
        }
    }

    val json = response.bodyAsText()
    return try {
        Json.decodeFromString(json)
    } catch (e: Exception) {
        e.printStackTrace()
        emptyList()
    }
}

suspend fun markTaskCompleted(taskId: Int): Boolean {
    val response = httpClient.patch("$SUPABASE_URL/rest/v1/erp_tasks?id=eq.$taskId") {
        headers {
            append("apikey", SUPABASE_API_KEY)
            append("Authorization", "Bearer $SUPABASE_API_KEY")
            append(HttpHeaders.ContentType, "application/json")
        }
        setBody("""{"status":"Completed"}""")
    }
    return response.status.value in 200..299
}




@Composable
fun ActionPlanScreen(
    supabase: SupabaseClient,
    prefs: SharedPreferences,
    onBack: () -> Unit
) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    var tasks by remember { mutableStateOf<List<ERPTask>>(emptyList()) }
    var showAddTaskDialog by remember { mutableStateOf(false) }
    var newTaskTitle by remember { mutableStateOf("") }
    var newTaskDesc by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    // ✅ Load tasks whenever date changes
    LaunchedEffect(selectedDate) {
        val identifier = prefs.getString("identifier", "") ?: return@LaunchedEffect
        tasks = fetchERPTasksForDate(
            identifier = identifier,
            date = selectedDate.toString()
        )


        println("📅 ERP tasks fetched for $selectedDate → ${tasks.size}")
    }

    // ✅ Proper Material background instead of black screen
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // 🔙 Back button
            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("⬅ Back to Dashboard")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🧭 Header
            Text(
                "Action Plan",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🗓 Calendar
            OutlookStyleCalendar(selectedDate) { date ->
                selectedDate = date
            }

            Spacer(modifier = Modifier.height(16.dp))

            // ➕ Add Task Button
            Button(
                onClick = { showAddTaskDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text("➕ Add Task for ${selectedDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))}")
            }

            // 📅 Task header
            Text(
                "Tasks for ${selectedDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 🧾 Tasks list
            if (tasks.isEmpty()) {
                Text(
                    "No ERP tasks for this day.",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 32.dp)
                )
            } else {
                LazyColumn {
                    items(tasks) { task ->
                        ERPTaskCard(task) {
                            scope.launch(Dispatchers.IO) {
                                val success = updateERPTaskStatus(

                                    taskId = task.id,
                                    newStatus = "Completed"
                                )
                                if (success == "true") {
                                    withContext(Dispatchers.Main) {
                                        tasks = tasks.map {
                                            if (it.id == task.id) it.copy(status = "Completed") else it
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 🗒️ Add Task Dialog
            if (showAddTaskDialog) {
                AlertDialog(
                    onDismissRequest = { showAddTaskDialog = false },
                    title = { Text("Add New ERP Task") },
                    text = {
                        Column {
                            OutlinedTextField(
                                value = newTaskTitle,
                                onValueChange = { newTaskTitle = it },
                                label = { Text("Task Title") },
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(8.dp))
                            OutlinedTextField(
                                value = newTaskDesc,
                                onValueChange = { newTaskDesc = it },
                                label = { Text("Description") },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    },
                    confirmButton = {
                        TextButton(onClick = {
                            scope.launch(Dispatchers.IO) {
                                val identifier = prefs.getString("identifier", "") ?: return@launch
                                addERPTask(

                                    userId = identifier,
                                    title = newTaskTitle,
                                    description = newTaskDesc,
                                    date = selectedDate.toString()

                                )
                                withContext(Dispatchers.Main) {
                                    showAddTaskDialog = false
                                    newTaskTitle = ""
                                    newTaskDesc = ""
                                    // Refresh
                                    tasks = fetchERPTasksForDate(

                                        identifier = identifier,
                                        date = selectedDate.toString()

                                    )
                                }
                            }
                        }) { Text("Save") }
                    },
                    dismissButton = {
                        TextButton(onClick = { showAddTaskDialog = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }
    }
}



// ✅ move this OUTSIDE (below) the ActionPlanScreen
@Composable
fun ERPTaskCard(task: ERPTask, onComplete: (ERPTask) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), // ✅ built-in elevation
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = task.title ?: "Untitled Task",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = task.description ?: "No description available",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Status: ${task.status ?: "Pending"}",
                color = if (task.status == "Completed") Color.Green else Color.Red,
                style = MaterialTheme.typography.bodySmall
            )

            if (task.status != "Completed") {
                Spacer(Modifier.height(12.dp))
                Button(onClick = { onComplete(task) }) {
                    Text("Mark as Completed")
                }
            }
        }
    }
}



@Composable
fun ClientActionPlanScreen(prefs: SharedPreferences, onBack: () -> Unit) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var tasks by remember { mutableStateOf<List<ERPTask>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        val identifier = prefs.getString("identifier", "") ?: ""
        try {
            tasks = fetchTodaysERPTasks(identifier)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Error loading tasks", Toast.LENGTH_SHORT).show()
        }
        isLoading = false
    }

    // ✅ Wrap the entire screen in a Surface
    Surface(color = MaterialTheme.colorScheme.background) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = onBack) {
                    Text("← Back")
                }
                Spacer(Modifier.width(8.dp))
                Text(
                    "Today's Action Plan",
                    style = MaterialTheme.typography.headlineSmall
                )
            }

            Spacer(Modifier.height(12.dp))

            when {
                isLoading -> CircularProgressIndicator()
                tasks.isEmpty() -> Text("No tasks for today 🎉")
                else -> {
                    LazyColumn {
                        items(tasks) { task ->
                            ERPTaskCard(task = task) { selectedTask ->
                                scope.launch {
                                    val success = markTaskCompleted(selectedTask.id)
                                    if (success) {
                                        tasks = tasks.map {
                                            if (it.id == selectedTask.id) it.copy(status = "Completed") else it
                                        }
                                        Toast.makeText(context, "✅ Task marked completed", Toast.LENGTH_SHORT).show()
                                    } else {
                                        Toast.makeText(context, "❌ Failed to update task", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}






suspend fun deleteEntryFromSupabase(id: Int, supabase: SupabaseClient): Boolean {
    return try {
        supabase.from("entries").delete {
                filter { eq("id", id) }
            }
        true
    } catch (e: Exception) {
        Log.e("SUPABASE_DELETE", "❌ Failed to delete from Supabase: ${e.message}")
        false
    }
}










suspend fun fetchUserRole(identifier: String): String? {
    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    return try {
        val response: JsonElement = client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/users") {
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
            }
            parameter("identifier", "eq.$identifier")
            parameter("select", "*")
        }.body()

        val user = when {
            response is JsonArray && response.isNotEmpty() -> response[0].jsonObject
            response is JsonObject -> response
            else -> null
        }

        val role = user?.get("role")?.jsonPrimitive?.contentOrNull
        Log.d("ROLE_FETCH", "✅ Role fetched: $role")
        role
    } catch (e: Exception) {
        Log.e("ROLE_FETCH", "❌ Error fetching user role: ${e.message}")
        null
    }
}








@Composable
fun DashboardStat(title: String, count: Int) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Bold)
        Text(text = count.toString(), fontSize = 20.sp)
    }
}

@Composable
fun DashboardSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp)
            .padding(bottom = 24.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}

@Composable
fun SessionItem(date: String, time: String, name: String) {
    Text("📅 $date • $time\n$name", modifier = Modifier.padding(vertical = 4.dp))
}

@Composable
fun MessageItem(name: String, message: String, onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClick() }
        .padding(vertical = 8.dp)) {
        Column {
            Text(text = name, fontWeight = FontWeight.Bold)
            Text(text = message, maxLines = 1)
        }
    }
}


@Composable
fun ClientItem(name: String, detail: String) {
    Text("👤 $name — $detail", modifier = Modifier.padding(vertical = 4.dp))
}


@Composable
fun TherapistDashboardScreen(
    userId: String,
    therapistId: String,
    messages: List<Message>,
    selectedClient: Relationship?,    // 👈 Add this parameter

    onPreviewProfile: () -> Unit,
    onNewSessionClick: () -> Unit = {},
    onEditBioClick: () -> Unit = {},
    onInboxClick: () -> Unit,
    onRefreshMessages: () -> Unit,
    onClientSelected: (Relationship) -> Unit,    // ✅ added missing comma
    onNavigateToActionPlan: () -> Unit           // ✅ new navigation callback
) {
    var selectedMessage by remember { mutableStateOf<Message?>(null) }
    var replyText by remember { mutableStateOf("") }
    var clients by remember { mutableStateOf<List<Relationship>>(emptyList()) }
    var selectedClientId by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()
    var requestList by remember { mutableStateOf<List<TherapistRequest>>(emptyList()) }

    LaunchedEffect(therapistId) {
        requestList = fetchPendingRequests(therapistId)
    }

    LaunchedEffect(Unit) {
        onRefreshMessages()
    }

    LaunchedEffect(therapistId) {
        println("Loading clients for therapistId: $therapistId")
        clients = fetchClientsForTherapist(therapistId)
        println("Fetched clients: $clients")
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
            .padding(16.dp)
    ) {
        item {
            Text("Therapist Dashboard", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(24.dp))

            ModernRaisedButton(
                text = "📝 Log New Session",
                onClick = onNewSessionClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            ModernRaisedButton(
                text = "📥 Inbox",
                onClick = onInboxClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            ModernRaisedButton(
                text = "✏️ Edit Bio",
                onClick = onEditBioClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            ModernRaisedButton(
                text = "👁 Preview My Profile",
                onClick = onPreviewProfile,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            // ✅ New button for Action Plan
            ModernRaisedButton(
                text = "🗓 View Action Plan",
                onClick = onNavigateToActionPlan,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            TherapistRequestListScreen(
                therapistId = therapistId,
                requestList = requestList,
                onRefreshRequests = {
                    coroutineScope.launch {
                        requestList = fetchPendingRequests(therapistId)
                    }
                },
                refreshClients = {
                    coroutineScope.launch {
                        clients = fetchClientsForTherapist(therapistId)
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Overview", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Total Clients: ${clients.size}")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Text("Messages", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            if (messages.isEmpty()) {
                Text("No messages available")
            } else {
                messages.forEach { message ->
                    MessageCard(
                        name = message.sender_role ?: "Unknown",
                        preview = message.content?.take(50) ?: "",
                        onClick = { selectedMessage = message }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Text("Upcoming Sessions", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("10:00 AM - John Doe")
                    Text("11:30 AM - Alice Smith")
                    Text("2:00 PM - Mark Davis")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Text("Clients", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    if (clients.isEmpty()) {
                        Text("No clients assigned.")
                    } else {
                        clients.forEach { relationship ->
                            Text(
                                text = "Client: ${relationship.clientName}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onClientSelected(relationship) }
                                    .padding(8.dp)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }
            }

            selectedClient?.let { client ->
                Spacer(modifier = Modifier.height(24.dp))
                Text("Client Details", style = MaterialTheme.typography.titleMedium)

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Name: ${client.clientName}")
                        Text("ID: ${client.clientId}")
                        Text("Status: ${client.status}")
                        Text("Linked Since: ${client.createdAt}")
                        Spacer(modifier = Modifier.height(12.dp))
                        Text("📊 Graphs and Progress Here")
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }

    selectedMessage?.let { message ->
        AlertDialog(
            onDismissRequest = {
                selectedMessage = null
                replyText = ""
            },
            title = { Text("Message from ${message.sender_role ?: "Unknown"}") },
            text = {
                Column {
                    Text(message.content ?: "")
                    Spacer(modifier = Modifier.height(12.dp))
                    OutlinedTextField(
                        value = replyText,
                        onValueChange = { replyText = it },
                        label = { Text("Reply") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        sendMessageToUser(
                            recipientId = message.sender_id,
                            content = replyText.trim(),
                            therapistId = therapistId,
                            senderRole = "therapist"
                        )
                        onRefreshMessages()

                        withContext(Dispatchers.Main) {
                            replyText = ""
                            selectedMessage = null
                        }
                    }
                }) {
                    Text("Send Reply")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    selectedMessage = null
                    replyText = ""
                }) {
                    Text("Close")
                }
            }
        )
    }
}











// OCDLogScreen.kt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OCDLogScreen(
    tableState: MutableState<MutableList<ObsessionEntry>>,
    selectedEntryIndex: MutableState<Int?>,
    counter: MutableState<Int>,
    prefs: SharedPreferences,
    saveCounter: (Int) -> Unit,
    saveTable: (List<ObsessionEntry>) -> Unit,
    supabase: SupabaseClient,
    onBack: () -> Unit,
    onNavigateToOCDLog: () -> Unit = {}
) {
    val context = LocalContext.current
    var showDeleteDialog by remember { mutableStateOf(false) }
    var entryToDeleteIndex by remember { mutableStateOf<Int?>(null) }
    var newObsession by remember { mutableStateOf("") }
    var newCompulsion by remember { mutableStateOf("") }

    var tableData by tableState

    // ✅ Load entries from Supabase on screen load
    LaunchedEffect(Unit) {
        val identifier = prefs.getString("identifier", "") ?: return@LaunchedEffect
        val url = URL("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries?select=*")

        val connection = withContext(Dispatchers.IO) {
            (url.openConnection() as HttpURLConnection).apply {
                requestMethod = "GET"
                setRequestProperty("apikey", BuildConfig.SUPABASE_ANON_KEY)
                setRequestProperty("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
            }
        }

        try {
            val responseText = withContext(Dispatchers.IO) {
                connection.inputStream.bufferedReader().use { it.readText() }
            }

            val jsonArray = JSONArray(responseText)
            val entries = mutableListOf<ObsessionEntry>()

            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)

                if (obj.optString("identifier", "") == identifier) {
                    entries.add(
                        ObsessionEntry(
                            id = obj.optInt("id", 0),
                            obsession = obj.optString("obsession", ""),
                            compulsion = obj.optString("compulsion", ""),
                            times = try {
                                obj.getInt("times")
                            } catch (e: Exception) {
                                0
                            },
                            identifier = obj.optString("identifier", "")
                        )
                    )
                }
            }

            tableData = entries.map {
                ObsessionEntry(
                    id = it.id,
                    obsession = it.obsession,
                    compulsion = it.compulsion,
                    times = it.times,
                    identifier = it.identifier
                )
            }.reversed().toMutableList()

            saveTable(tableData)
            Log.d("✅ OCDLogScreen", "Fetched ${entries.size} entries from Supabase")

        } catch (e: Exception) {
            Log.e("❌ OCDLogScreen", "Error fetching entries: ${e.message}")
        } finally {
            connection.disconnect()
        }
    }

    // ✅ Surface added for theme-aware background
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            OutlinedTextField(
                value = newObsession,
                onValueChange = { newObsession = it },
                label = { Text("Obsession") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )

            OutlinedTextField(
                value = newCompulsion,
                onValueChange = { newCompulsion = it },
                label = { Text("Compulsion") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )

            ModernRaisedButton(
                text = "➕ Add to Table",
                onClick = {
                    val newEntry = ObsessionEntry(
                        id = 0,
                        obsession = newObsession,
                        compulsion = newCompulsion,
                        times = 0,
                        identifier = prefs.getString("identifier", "") ?: ""
                    )

                    CoroutineScope(Dispatchers.IO).launch {
                        val client = HttpClient(OkHttp)
                        try {
                            val response = client.post("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries") {
                                headers {
                                    append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                                    append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                                    append("Content-Type", "application/json")
                                    append("Prefer", "return=representation")
                                }
                                setBody(
                                    buildJsonArray {
                                        add(
                                            buildJsonObject {
                                                put("obsession", newEntry.obsession)
                                                put("compulsion", newEntry.compulsion)
                                                put("times", newEntry.times)
                                                put("identifier", newEntry.identifier)
                                            }
                                        )
                                    }.toString()
                                )
                            }

                            Log.d("SUPABASE_INSERT", "✅ Inserted: ${response.status}")

                            withContext(Dispatchers.Main) {
                                tableData = (listOf(newEntry) + tableData).toMutableList()
                                saveTable(tableData)
                                newObsession = ""
                                newCompulsion = ""
                            }

                        } catch (e: Exception) {
                            Log.e("SUPABASE_INSERT", "❌ ${e.message}")
                        } finally {
                            client.close()
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Counter: ${counter.value}",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ModernRaisedButton(
                    text = "➕ Increase",
                    onClick = {
                        val index = selectedEntryIndex.value
                        if (index != null) {
                            counter.value += 1
                            saveCounter(counter.value)

                            val updatedEntry = tableData[index].copy(times = counter.value)

                            CoroutineScope(Dispatchers.IO).launch {
                                try {
                                    val client = HttpClient(OkHttp)
                                    val entryId = updatedEntry.id

                                    client.patch("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries?id=eq.$entryId") {
                                        headers {
                                            append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                                            append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                                            append("Content-Type", "application/json")
                                            append("Prefer", "return=representation")
                                        }
                                        setBody(
                                            buildJsonArray {
                                                add(buildJsonObject { put("times", updatedEntry.times) })
                                            }.toString()
                                        )
                                    }
                                    client.close()
                                } catch (e: Exception) {
                                    Log.e("SUPABASE_UPDATE", "❌ ${e.message}")
                                }
                            }

                            tableData = tableData.toMutableList().apply {
                                set(index, updatedEntry)
                            }
                            saveTable(tableData)
                        }
                    },
                    modifier = Modifier.weight(1f)
                )

                ModernRaisedButton(
                    text = "🔁 Reset",
                    onClick = {
                        val index = selectedEntryIndex.value
                        if (index != null) {
                            counter.value = 0
                            saveCounter(0)

                            val updatedEntry = tableData[index].copy(times = 0)

                            CoroutineScope(Dispatchers.IO).launch {
                                try {
                                    val client = HttpClient(OkHttp)
                                    val entryId = updatedEntry.id

                                    client.patch("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries?id=eq.$entryId") {
                                        headers {
                                            append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                                            append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                                            append("Content-Type", "application/json")
                                            append("Prefer", "return=representation")
                                        }
                                        setBody(
                                            buildJsonArray {
                                                add(buildJsonObject { put("times", 0) })
                                            }.toString()
                                        )
                                    }
                                    client.close()
                                } catch (e: Exception) {
                                    Log.e("SUPABASE_UPDATE", "❌ ${e.message}")
                                }
                            }

                            tableData = tableData.toMutableList().apply {
                                set(index, updatedEntry)
                            }
                            saveTable(tableData)
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
            }

            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "OCD Log:",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            tableData.forEachIndexed { index, entry ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .combinedClickable(
                            onClick = {
                                selectedEntryIndex.value = index
                                counter.value = entry.times
                                prefs.edit().putInt("selected_index", index).apply()
                                saveCounter(counter.value)
                            },
                            onLongClick = {
                                showDeleteDialog = true
                                entryToDeleteIndex = index
                            }
                        ),
                    elevation = CardDefaults.cardElevation(0.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            "Obsession : ${entry.obsession}",
                            fontSize = 15.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            "Compulsion : ${entry.compulsion}",
                            fontSize = 15.sp,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "Count: ${entry.times}",
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.align(Alignment.CenterEnd)
                            )
                        }
                    }
                }
            }

            if (showDeleteDialog && entryToDeleteIndex != null) {
                AlertDialog(
                    onDismissRequest = { showDeleteDialog = false },
                    title = { Text("Delete Entry") },
                    text = { Text("Are you sure you want to delete this entry?") },
                    confirmButton = {
                        TextButton(onClick = {
                            val index = entryToDeleteIndex
                            if (index != null) {
                                val entry = tableData[index]
                                CoroutineScope(Dispatchers.IO).launch {
                                    try {
                                        supabase.from("entries").delete {
                                            filter { eq("id", entry.id) }
                                        }
                                        withContext(Dispatchers.Main) {
                                            tableData = tableData.toMutableList().apply { removeAt(index) }
                                            saveTable(tableData)
                                            if (selectedEntryIndex.value == index) {
                                                selectedEntryIndex.value = null
                                                counter.value = 0
                                            }
                                            showDeleteDialog = false
                                            entryToDeleteIndex = null
                                        }
                                    } catch (e: Exception) {
                                        Log.e("SUPABASE_DELETE", "❌ ${e.message}")
                                    }
                                }
                            }
                        }) { Text("Delete") }
                    },
                    dismissButton = {
                        TextButton(onClick = {
                            showDeleteDialog = false
                            entryToDeleteIndex = null
                        }) { Text("Cancel") }
                    }
                )
            }
        }
    }
}





//@Composable
//fun EditBioScreen(therapistId: String, onSave: () -> Unit) {
//    var yearsState by remember { mutableStateOf("") }
//    var qualificationsState by remember { mutableStateOf("") }
//    var locationState by remember { mutableStateOf("") }
//    var feesState by remember { mutableStateOf("") }
//    var aboutState by remember { mutableStateOf("") }
//    val scope = rememberCoroutineScope()
//    val context = LocalContext.current
//    LaunchedEffect(therapistId) {
//        val bio = fetchTherapistBio(therapistId) // No Dispatchers.IO
//
//        println("📥 Bio fetched: $bio")
//
//        bio?.let {
//            yearsState = it.opt("years_practice")?.toString() ?: ""
//            qualificationsState = it.opt("qualifications")?.toString() ?: ""
//            locationState = it.opt("location")?.toString() ?: ""
//            feesState = it.opt("fees")?.toString() ?: ""
//            aboutState = it.opt("about")?.toString() ?: ""
//        }
//    }
//
//
//
//    // 🧠 UI fields
//    Column(modifier = Modifier.padding(16.dp)) {
//        OutlinedTextField(
//            value = yearsState,
//            onValueChange = { yearsState = it },
//            label = { Text("Years") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = qualificationsState,
//            onValueChange = { qualificationsState = it },
//            label = { Text("Qualifications") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = locationState,
//            onValueChange = { locationState = it },
//            label = { Text("Location") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = feesState,
//            onValueChange = { feesState = it },
//            label = { Text("Fees") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = aboutState,
//            onValueChange = { aboutState = it },
//            label = { Text("About") },
//            modifier = Modifier.fillMaxWidth(),
//            maxLines = 4
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                saveBioToSupabase(
//                    therapistId,
//                    yearsState,
//                    qualificationsState,
//                    locationState,
//                    feesState,
//                    aboutState
//                )
//                onSave()
//            },
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            Text("Save Bio")
//        }
//    }
//}


@Composable
fun NativePdfViewerScreen() {
    val context = LocalContext.current
    val imageBitmap = remember { mutableStateOf<ImageBitmap?>(null) }

    // ✅ Load PDF on first launch
    LaunchedEffect(Unit) {
        try {
            val file = File(context.cacheDir, "OCD_Thought_Log_Green.pdf")
            context.assets.open("OCD_Thought_Log_Green.pdf").use { input ->
                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                }
            }

            val fileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY)
            val pdfRenderer = PdfRenderer(fileDescriptor)
            val page = pdfRenderer.openPage(0)

            val bitmap = Bitmap.createBitmap(page.width, page.height, Bitmap.Config.ARGB_8888)
            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            page.close()
            pdfRenderer.close()

            imageBitmap.value = bitmap.asImageBitmap()
        } catch (e: Exception) {
            println("❌ Error loading PDF: ${e.message}")
        }
    }

    // ✅ Wrap in Surface for proper theme background and padding
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // 🧾 Header
            Text(
                "📄 OCD Thought Log",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 🖨️ Print button
            Button(
                onClick = { printPdf(context) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("🖨️ Print This PDF")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🖼️ PDF image display
            imageBitmap.value?.let {
                Image(
                    bitmap = it,
                    contentDescription = "OCD Thought Log PDF",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(it.width.toFloat() / it.height.toFloat())
                        .clip(RoundedCornerShape(8.dp))
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                )
            } ?: run {
                // 🕓 Placeholder while loading
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}



suspend fun fetchEntriesHttp(userId: String): List<Entry> {
    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    return try {
        val response: HttpResponse =
            client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries") {
                headers {
                    append(
                        "apikey",
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                    )
                    append(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                    )
                    append("Accept", "application/json")
                }
                url {
                    parameters.append("identifier", "eq.$userId")
                    parameters.append("select", "*")
                }
            }

        if (response.status == HttpStatusCode.OK) {
            val bodyText = response.bodyAsText()
            Log.d("SUPABASE_RESPONSE", "📦 Raw: $bodyText")
            Json.decodeFromString(bodyText)
        } else {
            Log.e("SUPABASE_RESPONSE", "❌ HTTP error: ${response.status}")
            emptyList()
        }
    } catch (e: Exception) {
        Log.e("SUPABASE_RESPONSE", "❌ Exception: ${e.message}")
        emptyList()
    } finally {
        client.close()
    }
}


fun printPdf(context: Context) {
    val printManager = context.getSystemService(Context.PRINT_SERVICE) as PrintManager
    val input = context.assets.open("OCD_Thought_Log_Green.pdf")
    val file = File(context.cacheDir, "OCD_Thought_Log_Green.pdf")
    file.outputStream().use { input.copyTo(it) }

    val printAdapter = PdfDocumentAdapter(context, file.path)
    printManager.print("OCD Thought Log", printAdapter, null)
}

suspend fun loginWithEmail(
    email: String,
    password: String,
    httpClient: HttpClient
): Pair<String, String>? {
    return try {
        val response: HttpResponse = httpClient.post(
            "https://ituaxigakgytlknrjkzz.supabase.co/auth/v1/token?grant_type=password"
        ) {
            contentType(ContentType.Application.Json)
            setBody(mapOf("email" to email, "password" to password))
            headers {
                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
            }
        }

        val responseBody = response.bodyAsText()
        println("🔐 Login response: $responseBody")

        val json = Json { ignoreUnknownKeys = true }
        val jsonObject = json.parseToJsonElement(responseBody).jsonObject

        val accessToken = jsonObject["access_token"]?.jsonPrimitive?.content
        val userId = jsonObject["user"]?.jsonObject?.get("id")?.jsonPrimitive?.content

        if (!accessToken.isNullOrBlank() && !userId.isNullOrBlank()) {
            Pair(userId, accessToken)
        } else {
            null
        }
    } catch (e: Exception) {
        println("❌ Login error: ${e.message}")
        null
    }
}



suspend fun fetchIdentifierByEmail(email: String, httpClient: HttpClient): String? {
    val response = httpClient.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/users") {
        headers {
            append("apikey", BuildConfig.SUPABASE_ANON_KEY)
            append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
        }
        parameter("email", "eq.$email")
        parameter("select", "identifier")
    }

    val body = response.bodyAsText()

    Log.d("FETCH_ID", "Raw response: $body")

    val jsonArray = Json.parseToJsonElement(body).jsonArray

    return if (jsonArray.isNotEmpty()) {
        jsonArray[0].jsonObject["identifier"]?.jsonPrimitive?.content
    } else null
}


@Serializable
data class JournalEntry(
    val id: Int, val created_at: String, val identifier: String, val journalentry: String
)


suspend fun fetchJournalEntries(userId: String): List<JournalEntry> {
    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    return try {
        val response: HttpResponse =
            client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/journals") {
                headers {
                    append("apikey", "YOUR_SUPABASE_KEY")
                    append("Authorization", "Bearer YOUR_SUPABASE_KEY")
                    append("Accept", "application/json")
                }
                parameter("identifier", "eq.$userId")
            }

        if (response.status == HttpStatusCode.OK) {
            response.body()
        } else {
            Log.e("FETCH_JOURNAL", "Error: ${response.status}")
            emptyList()
        }
    } catch (e: Exception) {
        Log.e("FETCH_JOURNAL", "Exception: ${e.message}")
        emptyList()
    } finally {
        client.close()
    }
}


@Composable
fun PdfViewerScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("📄 OCD Thought Log", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        // View PDF


        Spacer(modifier = Modifier.height(16.dp))

        // Print Button
        ModernRaisedButton(
            text = "🖨️ Print This PDF",
            onClick = { printPdf(context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

    }
}

suspend fun fetchJournalEntriesFilteredLocally(
    supabase: SupabaseClient, identifier: String
): List<JournalEntry> {
    return try {
        val allEntries = supabase.from("journals").select().decodeList<JournalEntry>()

        // Manual filter in Kotlin
        allEntries.filter { it.identifier == identifier }
    } catch (e: Exception) {
        Log.e("SUPABASE", "❌ Failed to fetch or filter journal entries: ${e.message}")
        emptyList()
    }
}


suspend fun saveTableToSupabase(newEntry: ObsessionEntry) {
    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000
        }
    }

    // ✅ Build the upload-safe version (no ID)
    val upload = ObsessionUpload(
        obsession = newEntry.obsession,
        compulsion = newEntry.compulsion,
        times = newEntry.times,
        identifier = newEntry.identifier
    )

    try {
        val response = client.post("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries") {
            headers {
                append(
                    "apikey",
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                )
                append(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                )
                append("Prefer", "return=representation")
            }

            contentType(ContentType.Application.Json)
            setBody(upload) // ✅ upload the version without the id
        }

        println("✅ Supabase response: ${response.status}")
    } catch (e: Exception) {
        println("❌ Supabase upload failed: ${e.message}")
    } finally {
        client.close()
    }
}


@Composable
fun GradientBackground(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2196F3), // Blue
                        Color(0xFFBBDEFB)  // Light Blue
                    )
                )
            )
            .padding(16.dp)
    ) {
        content()
    }
}


suspend fun fetchUserIdentifierByEmailHttp(
    httpClient: HttpClient, email: String, prefs: SharedPreferences
) {
    try {
        val response: HttpResponse =
            httpClient.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/users") {
                headers {
                    append(
                        "apikey",
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                    )
                    append(
                        "Authorization",
                        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                    )
                    append("Accept", "application/json")
                }
                parameter("email", "eq.$email")
            }

        val responseBody = response.bodyAsText()
        Log.d("USER_IDENTIFIER", "Response: $responseBody")

        val identifierRegex = Regex(""""identifier"\s*:\s*"([a-zA-Z0-9_\-]+)"""")
        val match = identifierRegex.find(responseBody)

        val identifier = match?.groupValues?.get(1)

        if (identifier != null) {
            Log.d("FETCH_USER_ID", "Storing user_id: $identifier")

            prefs.edit().putString("user_id", identifier).apply()
            Log.d("USER_IDENTIFIER", "Saved identifier: $identifier")
            Log.d("FULL_RESPONSE", responseBody)

        } else {
            Log.e("USER_IDENTIFIER", "Identifier not found in response.")
        }

    } catch (e: Exception) {
        Log.e("USER_IDENTIFIER", "Error fetching identifier: ${e.message}")
    }
}

suspend fun updateEntryTimes(identifier: String, newTimes: Int) {
    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    val response =
        client.patch("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries?identifier=eq.$identifier") {
            headers {
                append(
                    "apikey",
                    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                )
                append(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                )
                append("Content-Type", "application/json")
                append("Prefer", "return=minimal")
            }
            setBody(mapOf("times" to newTimes))
        }

    println("PATCH status: ${response.status}")
    client.close()
}


class MainActivity : ComponentActivity() {
    private val SELECTED_INDEX_KEY = "selected_index"
    private val PREFS_NAME = "ocd_prefs"
    private val COUNTER_KEY = "counter"
    private val TABLE_KEY = "table_entries"
    private val gson = Gson()
    lateinit var supabase: SupabaseClient
    lateinit var httpClient: HttpClient
    //val coroutineScope = rememberCoroutineScope()

    enum class UserMode {
        CLIENT,
        THERAPIST
    }

    object UserModeManager {
        private const val PREFS_NAME = "user_mode_prefs"
        private const val KEY_MODE = "user_mode"

        fun get(context: Context): UserMode {
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            val mode = prefs.getString(KEY_MODE, UserMode.CLIENT.name)
            return UserMode.valueOf(mode!!)
        }

        fun set(context: Context, mode: UserMode) {
            val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            prefs.edit().putString(KEY_MODE, mode.name).apply()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        httpClient = HttpClient(OkHttp) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }

        val supabase = createSupabaseClient(
            supabaseUrl = "https://ituaxigakgytlknrjkzz.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
        ) {
            install(Auth) {
                alwaysAutoRefresh = true
                autoSaveToStorage = false
                autoLoadFromStorage = false
            }
            install(Postgrest)
        }

        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedTableJson = prefs.getString(TABLE_KEY, "[]")
        val type = object : TypeToken<MutableList<ObsessionEntry>>() {}.type
        val savedTableData =
            gson.fromJson<MutableList<ObsessionEntry>>(savedTableJson, type) ?: mutableListOf()

        val savedSelectedIndex = prefs.getInt(SELECTED_INDEX_KEY, -1).takeIf { it >= 0 }
        val savedCounter = prefs.getInt(COUNTER_KEY, 0)
        val accessToken = prefs.getString("access_token", null)
        val refreshToken = prefs.getString("refresh_token", null)
        val hasValidTokens = accessToken != null && refreshToken != null
        val httpClient = HttpClient()
        val isLoggedIn = prefs.getBoolean("is_logged_in", false)
        val role = prefs.getString("user_role", "")
        val initialScreen = if (isLoggedIn) {



            if (role == "Therapist") Screen.TherapistDashboard else Screen.Main
        } else {
            Screen.Main
        }

        setContent {

            val context = LocalContext.current
            var userMode by remember { mutableStateOf(UserModeManager.get(context)) }

            LaunchedEffect(userMode) {
                UserModeManager.set(context, userMode)
            }

            val coroutineScope = rememberCoroutineScope()

            OcdworldTheme {
                val tableState = remember { mutableStateOf(mutableListOf<ObsessionEntry>()) }
                val selectedEntryIndex = remember { mutableStateOf<Int?>(null) }
                val counterState = remember { mutableStateOf(0) }
                val journalDataState = remember { mutableStateOf<List<JournalEntry>>(emptyList()) }
                val ocdLogState = remember { mutableStateOf<List<OcdLogEntry>>(emptyList()) }
                var messages by remember { mutableStateOf<List<Message>>(emptyList()) }
                val clients = remember { mutableStateOf<List<Relationship>>(emptyList()) }

                val tableDataState = remember { mutableStateOf(savedTableData) }
                val httpClient = remember { this@MainActivity.httpClient }
                val userId = prefs.getString("user_id", "") ?: ""
                val selectedIndexState = remember { mutableStateOf(savedSelectedIndex) }
                var currentScreen by remember { mutableStateOf(initialScreen) }  // ✅ declared early
                val selectedClientId by remember { mutableStateOf<String?>(null) }
                var selectedClient by remember { mutableStateOf<Relationship?>(null) }
                val therapistId = prefs.getString("user_id", "") ?: ""

                LaunchedEffect(therapistId) {
                    val fetched = fetchClientsForTherapist(therapistId)
                    println("✅ Clients fetched (${fetched.size}):")
                    fetched.forEach {
                        println("➡️ ${it.clientId} - ${it.clientName}")
                    }
                    clients.value = fetched
                }

                val saveCounter: (Int) -> Unit = { count ->
                    prefs.edit().putInt("counter", count).apply()
                }

                val saveTable: (List<ObsessionEntry>) -> Unit = { updatedList -> }

                // ✅ Everything wrapped in a Column
                Column(modifier = Modifier.fillMaxSize()) {

                    // ✅ TOGGLE ROW AT TOP
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.DarkGray)
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = if (userMode == UserMode.THERAPIST) "Therapist Mode" else "Client Mode",
                            color = Color.White
                        )
                        Switch(
                            checked = userMode == UserMode.THERAPIST,
                            onCheckedChange = {
                                userMode = if (it) UserMode.THERAPIST else UserMode.CLIENT
                                currentScreen = Screen.Main // reset to main when toggled
                            }
                        )
                    }

                    // ✅ YOUR SCREEN HANDLER STARTS HERE
                    when (currentScreen) {

                        Screen.ClientActionPlan -> ClientActionPlanScreen(
                            prefs = prefs,
                            onBack = { currentScreen = Screen.Main }  // ✅ Back to main
                        )


                        Screen.ActionPlan -> ActionPlanScreen(
                            supabase = supabase,
                            prefs = prefs,
                            onBack = { currentScreen = Screen.TherapistDashboard }
                        )


                        Screen.OCDLog -> OCDLogScreen(
                            tableState = tableState,
                            selectedEntryIndex = selectedEntryIndex,
                            counter = counterState,
                            prefs = prefs,
                            saveCounter = saveCounter,
                            saveTable = saveTable,
                            supabase = supabase,
                            onBack = { currentScreen = Screen.Main }
                        )

                        Screen.TherapistDashboard -> TherapistDashboardScreen(
                            userId = prefs.getString("identifier", "") ?: "",
                            therapistId = prefs.getString("identifier", "") ?: "",
                            messages = messages,
                            selectedClient = selectedClient,
                            onPreviewProfile = { currentScreen = Screen.TherapistProfilePreview },
                            onNewSessionClick = { currentScreen = Screen.NewSession },
                            onEditBioClick = { currentScreen = Screen.TherapistBio },
                            onInboxClick = { currentScreen = Screen.TherapistInbox },
                            onRefreshMessages = {
                                coroutineScope.launch(Dispatchers.IO) {
                                    val id = prefs.getString("identifier", "") ?: ""
                                    messages = fetchMessagesForTherapist(id)
                                }
                            },
                            onClientSelected = { relationship ->
                                selectedClient = relationship
                                currentScreen = Screen.ClientDetails
                            },
                            onNavigateToActionPlan = { currentScreen = Screen.ActionPlan } // ✅ add this line
                        )


                        Screen.ClientDetails -> selectedClient?.let { client ->
                            ClientDetailsScreen(
                                client = client,
                                onBack = { currentScreen = Screen.TherapistDashboard }
                            )
                        }

                        Screen.Dashboard -> TherapistDashboardScreen(
                            userId = userId,
                            therapistId = userId,
                            messages = messages,
                            selectedClient = selectedClient,
                            onPreviewProfile = { currentScreen = Screen.TherapistProfilePreview },
                            onNewSessionClick = { currentScreen = Screen.NewSession },
                            onEditBioClick = { currentScreen = Screen.TherapistBio },
                            onInboxClick = { currentScreen = Screen.TherapistInbox },
                            onRefreshMessages = {
                                coroutineScope.launch(Dispatchers.IO) {
                                    val id = prefs.getString("identifier", "") ?: ""
                                    messages = fetchMessagesForTherapist(id)
                                }
                            },
                            onClientSelected = {
                                selectedClient = it
                                currentScreen = Screen.ClientDetails
                            },
                            onNavigateToActionPlan = { currentScreen = Screen.ActionPlan } // ✅ added line
                        )


                        Screen.NewSession -> NewSessionScreen(
                            therapistId = therapistId,
                            acceptedClients = clients.value,
                            onBack = { currentScreen = Screen.Dashboard }
                        )

                        Screen.Loading -> Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }

                        Screen.About -> AboutScreen(onBack = { currentScreen = Screen.Main })

                        Screen.TherapistInbox -> TherapistInboxScreen(
                            therapistId = prefs.getString("identifier", "") ?: "",
                            onBack = { currentScreen = Screen.TherapistDashboard }
                        )

                        Screen.TherapistProfilePreview -> TherapistProfilePreviewScreen(
                            therapistId = prefs.getString("identifier", "") ?: "",
                            onBack = { currentScreen = Screen.TherapistDashboard }
                        )

                        Screen.TherapistBio -> TherapistBioScreen(
                            therapistId = prefs.getString("identifier", "") ?: "",
                            onSave = { currentScreen = Screen.TherapistDashboard }
                        )

                        Screen.Pdf -> NativePdfViewerScreen()

                        Screen.Signup -> SignupScreen(
                            supabase = supabase,
                            onSignupSuccess = { currentScreen = Screen.Login },
                            onBack = { currentScreen = Screen.Login }
                        )

                        Screen.Main -> {
                            if (userMode == UserMode.THERAPIST) {
                                TherapistDashboardScreen(
                                    userId = prefs.getString("identifier", "") ?: "",
                                    therapistId = prefs.getString("identifier", "") ?: "",
                                    messages = messages,
                                    selectedClient = selectedClient,
                                    onPreviewProfile = { currentScreen = Screen.TherapistProfilePreview },
                                    onNewSessionClick = { currentScreen = Screen.NewSession },
                                    onEditBioClick = { currentScreen = Screen.TherapistBio },
                                    onInboxClick = { currentScreen = Screen.TherapistInbox },
                                    onRefreshMessages = {
                                        coroutineScope.launch(Dispatchers.IO) {
                                            val id = prefs.getString("identifier", "") ?: ""
                                            messages = fetchMessagesForTherapist(id)
                                        }
                                    },
                                    onClientSelected = { relationship ->
                                        selectedClient = relationship
                                        currentScreen = Screen.ClientDetails
                                    },
                                    onNavigateToActionPlan = { currentScreen = Screen.ActionPlan } // ✅ added Action Plan navigation
                                )
                            } else {
                                OCDApp(

                                    initialCounter = savedCounter,
                                    tableState = tableDataState,
                                    initialSelectedIndex = selectedIndexState.value,
                                    prefs = prefs,
                                    onNavigateToCoping = { currentScreen = Screen.Coping },
                                    onNavigateToDiary = { currentScreen = Screen.Diary },
                                    onNavigateToChart = { currentScreen = Screen.Chart },
                                    onNavigateToSoundMenu = { currentScreen = Screen.SoundMenu },
                                    onNavigateToSignup = { currentScreen = Screen.Signup },
                                    onNavigateToPdf = { currentScreen = Screen.Pdf },
                                    onSignOutClick = {
                                        prefs.edit().clear().apply()
                                        currentScreen = Screen.Login
                                    },
                                    onClientActionPlanClick = { currentScreen = Screen.ClientActionPlan },

                                    onNavigateToSearchTherapist = { currentScreen = Screen.SearchTherapist },
                                    onNavigateToOCDLog = { currentScreen = Screen.OCDLog },
                                    onNavigateToAbout = { currentScreen = Screen.About },
                                    onNavigateToClientActionPlan = { currentScreen = Screen.ClientActionPlan },
                                    saveCounter = saveCounter,
                                    saveTable = saveTable,
                                    supabase = supabase,

                                )
                            }
                        }


                        Screen.Login -> LoginScreen(
                            currentScreenSetter = { currentScreen = it },
                            supabase = supabase,
                            onLoginSuccess = { currentScreen = Screen.Loading },
                            onNavigateToSignup = { currentScreen = Screen.Signup },
                            httpClient = httpClient
                        )

                        Screen.SearchTherapist -> SearchTherapistScreen(
                            supabase = supabase,
                            onBack = { currentScreen = Screen.Main }
                        )

                        Screen.Coping -> CopingTechniquesScreen(onBack = { currentScreen = Screen.Main })

                        Screen.Diary -> DiaryScreen(
                            supabase = supabase,
                            onBack = { currentScreen = Screen.Main }
                        )

                        Screen.SoundMenu -> SoundMenuScreen(onBack = { currentScreen = Screen.Main })

                        Screen.Chart -> ChartScreen(
                            entries = tableDataState.value,
                            onBack = { currentScreen = Screen.Main }
                        )
                    }
                }
            }
        }}



        @Composable
        fun LoginScreen(
            currentScreenSetter: (Screen) -> Unit,
            supabase: SupabaseClient,
            onLoginSuccess: () -> Unit,
            onNavigateToSignup: () -> Unit,
            httpClient: HttpClient
        ) {
            val context = LocalContext.current
            val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
            val coroutineScope = rememberCoroutineScope()

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            // ✅ Use Surface for theme-aware background (fixes black screen)
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(WindowInsets.systemBars.asPaddingValues()),
                color = MaterialTheme.colorScheme.background
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = PasswordVisualTransformation(),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    ModernRaisedButton(
                        text = "🔐 Login",
                        onClick = {
                            coroutineScope.launch {
                                val result = loginWithEmail(email, password, httpClient)
                                if (result != null) {
                                    val (userId, token) = result
                                    prefs.edit().putString("user_id", userId).apply()
                                    prefs.edit().putString("access_token", token).apply()
                                    prefs.edit().putBoolean("is_logged_in", true).apply()
                                    Log.d("LOGIN_FLOW", "✅ Logged in with ID: $userId")

                                    val client = HttpClient(OkHttp) {
                                        install(ContentNegotiation) {
                                            json(Json { ignoreUnknownKeys = true })
                                        }
                                    }

                                    // PATCH the identifier
                                    try {
                                        val patchResponse: HttpResponse = client.patch("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/users") {
                                            headers {
                                                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                                                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                                                append("Content-Type", "application/json")
                                            }
                                            parameter("email", "eq.$email")
                                            setBody(buildJsonObject {
                                                put("identifier", userId)
                                            })
                                        }
                                        Log.d("LOGIN_FLOW", "✅ Identifier patched: ${patchResponse.status}")
                                    } catch (e: Exception) {
                                        Log.e("LOGIN_FLOW", "❌ Failed to patch identifier: ${e.message}")
                                    }

                                    // FETCH user by identifier
                                    try {
                                        val response: List<JsonObject> = client.get("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/users") {
                                            headers {
                                                append("apikey", BuildConfig.SUPABASE_ANON_KEY)
                                                append("Authorization", "Bearer ${BuildConfig.SUPABASE_ANON_KEY}")
                                            }
                                            parameter("identifier", "eq.$userId")
                                            parameter("select", "*")
                                        }.body()

                                        if (response.isNotEmpty()) {
                                            val user = response[0]
                                            val roleFetched = user["role"]?.jsonPrimitive?.contentOrNull
                                            val identifierFetched = user["identifier"]?.jsonPrimitive?.contentOrNull

                                            Log.d("LOGIN_FLOW", "✅ Found identifier: $identifierFetched and role: $roleFetched")

                                            prefs.edit().putString("user_role", roleFetched).apply()
                                            prefs.edit().putString("identifier", identifierFetched).apply()
                                        } else {
                                            Log.w("LOGIN_FLOW", "⚠️ No user found for identifier: $userId")
                                        }
                                    } catch (e: Exception) {
                                        Log.e("LOGIN_FLOW", "❌ Error fetching user by identifier: ${e.message}")
                                        e.printStackTrace()
                                    }

                                    onLoginSuccess()
                                } else {
                                    Log.e("LOGIN_FLOW", "❌ Login failed: Invalid credentials")
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    ModernRaisedButton(
                        text = "Don't have an account? Sign up",
                        onClick = onNavigateToSignup,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }









@Composable
fun SoundMenuScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val sounds = listOf("White Noise", "Rain", "Rainforest", "River")

    val soundMap = mapOf(
        "White Noise" to R.raw.white_noise,
        "Rain" to R.raw.rain,
        "Rainforest" to R.raw.rainforest,
        "River" to R.raw.river
    )

    val imageMap = mapOf(
        "White Noise" to R.drawable.bg_white_noise,
        "Rain" to R.drawable.bg_rain,
        "Rainforest" to R.drawable.bg_rainforest,
        "River" to R.drawable.bg_river

    )

    var currentBg by remember { mutableStateOf(R.drawable.bg_white_noise) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer?.release()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // ✅ Background Image
        Image(
            painter = painterResource(id = currentBg),
            contentDescription = null,
            contentScale = ContentScale.Crop,

            modifier = Modifier.fillMaxSize()
        )

        // ✅ UI Content on top
        Column(
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Select a Sound", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))

            sounds.forEach { sound ->
                ModernRaisedButton(
                    text = sound,
                    onClick = {
                        mediaPlayer?.release()
                        val resId = soundMap[sound]
                        val bgId = imageMap[sound]

                        if (resId != null) {
                            mediaPlayer = MediaPlayer.create(context, resId)
                            mediaPlayer?.start()
                        }

                        if (bgId != null) {
                            currentBg = bgId
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OCDApp(
    initialCounter: Int,
    tableState: MutableState<MutableList<ObsessionEntry>>,
    initialSelectedIndex: Int?,
    prefs: SharedPreferences,
    onNavigateToCoping: () -> Unit,
    onNavigateToDiary: () -> Unit,
    onNavigateToChart: () -> Unit,
    onNavigateToSoundMenu: () -> Unit,
    onNavigateToSignup: () -> Unit,
    onNavigateToPdf: () -> Unit,
    onNavigateToSearchTherapist: () -> Unit,
    saveCounter: (Int) -> Unit,
    saveTable: (List<ObsessionEntry>) -> Unit,
    onNavigateToOCDLog: () -> Unit,
    onNavigateToAbout: () -> Unit,
    onSignOutClick: () -> Unit,
    onClientActionPlanClick: () -> Unit,
    onNavigateToClientActionPlan: () -> Unit, // ✅ ADD THIS LINE



    supabase: SupabaseClient
) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    var obsessionText by remember { mutableStateOf("") }
    var compulsionText by remember { mutableStateOf("") }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var entryToDeleteIndex by remember { mutableStateOf<Int?>(null) }
    var tableData by tableState
    var selectedEntryIndex by remember { mutableStateOf(initialSelectedIndex) }
    var counter by remember {
        mutableStateOf(initialSelectedIndex?.let { index -> tableState.value.getOrNull(index)?.times }
            ?: initialCounter)
    }

    LaunchedEffect(Unit) {
        val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
        val userId = prefs.getString("user_id", "") ?: ""
        println("DEBUG: Trying to fetch for userId = '$userId'")

        try {
            val entries = fetchEntriesHttp(userId)
            val converted = entries.map {
                ObsessionEntry(it.id, it.obsession, it.compulsion, it.times, it.identifier)
            }
            tableData = converted.reversed().toMutableList()
            println("✅ Table data updated with \${tableData.size} entries")
        } catch (e: Exception) {
            println("❌ Failed to fetch entries: \${e.message}")
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
//            OutlinedTextField(
//                value = obsessionText,
//                onValueChange = { obsessionText = it },
//                label = { Text("Name of Obsession") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = compulsionText,
//                onValueChange = { compulsionText = it },
//                label = { Text("Name of Compulsion") },
//                modifier = Modifier.fillMaxWidth()
//            )

            Spacer(modifier = Modifier.height(8.dp))

            FeatureCard("User Sign-Up", "Create a new user account", onNavigateToSignup)

            FeatureCard("OCD Log", "View and manage your logged obsessions", onNavigateToOCDLog)

            FeatureCard("View PDF", "Export and review your thought log", onNavigateToPdf)
            FeatureCard(
                "Sound Menu", "Listen to relaxing or grounding sounds", onNavigateToSoundMenu
            )

//            Button(
//                onClick = {
//                    if (obsessionText.isNotBlank()) {
//                        val identifier = prefs.getString("identifier", "") ?: ""
//                        val accessToken = prefs.getString("access_token", "") ?: ""
//
//                        val newEntry =
//                            ObsessionEntry(0, obsessionText, compulsionText, 0, identifier)
//                        coroutineScope.launch { saveTableToSupabase(newEntry) }
//                        tableData = (listOf(newEntry) + tableData).toMutableList()
//                        saveTable(tableData)
//                        obsessionText = ""
//                        compulsionText = ""
//                        CoroutineScope(Dispatchers.IO).launch {
//                            try {
//                                val json = Json.encodeToString(newEntry)
//                                val response: HttpResponse =
//                                    HttpClient(OkHttp).post("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries") {
//                                        headers {
//                                            append("apikey", BuildConfig.SUPABASE_ANON_KEY)
//                                            append("Authorization", "Bearer $accessToken")
//                                            append("Content-Type", "application/json")
//                                        }
//                                        setBody(
//                                            TextContent(
//                                                text = json,
//                                                contentType = ContentType.Application.Json
//                                            )
//                                        )
//                                    }
//                                if (!response.status.isSuccess()) {
//                                    println("Supabase upload failed: \${response.status}")
//                                }
//                            } catch (e: Exception) {
//                                println("Exception posting: \${e.message}")
//                            }
//                        }
//                    }
//                }, modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Add to Table")
//            }

            Spacer(modifier = Modifier.height(16.dp))

          //  Text("Counter: $counter", style = MaterialTheme.typography.titleLarge)

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
//                Button(onClick = {
//
//                    val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
//                    val accessToken = prefs.getString("access_token", "") ?: ""
//                    if (selectedEntryIndex != null) {
//                        val index = selectedEntryIndex!!
//                        tableData[index].times++
//                        counter = tableData[index].times
//                        saveTable(tableData)
//                        saveCounter(counter)
//
//                        val updatedTimes = tableData[index].times
//                        val entryId = tableData[index].id
//
//                        CoroutineScope(Dispatchers.IO).launch {
//                            try {
//                                val client = HttpClient(OkHttp)
//                                val url =
//                                    "https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries?id=eq.$entryId"
//                                val response: HttpResponse = client.request(url) {
//                                    method = HttpMethod.Patch
//                                    headers {
//                                        append("apikey", BuildConfig.SUPABASE_ANON_KEY)
//                                        append("Authorization", "Bearer $accessToken")
//                                        append("Content-Type", "application/json")
//                                        append("Prefer", "return=minimal")
//                                    }
//                                    setBody("""{ "times": $updatedTimes }""")
//                                }
//                                if (response.status.isSuccess()) {
//                                    Log.d("PATCH_SUCCESS", "✅ Updated times to $updatedTimes")
//                                } else {
//                                    Log.e("PATCH_FAIL", "❌ Failed to update: \${response.status}")
//                                }
//                            } catch (e: Exception) {
//                                Log.e("PATCH_ERROR", "❌ HTTP error: \${e.message}")
//                            }
//                        }
//                    }
//                }) { Text("Increase") }


            }

            Spacer(modifier = Modifier.height(16.dp))

            FeatureCard("Progress Chart", "View your OCD tracking progress", onNavigateToChart)
            FeatureCard("Journal", "Log thoughts and feelings", onNavigateToDiary)
            FeatureCard("Coping Techniques", "Discover ways to manage OCD", onNavigateToCoping)
            FeatureCard(
                "Find a Therapist",
                "Search for mental health professionals",
                onNavigateToSearchTherapist
            )
            FeatureCard(
                "Action Plan",
                "See today's ERP tasks and mark them complete",
                onNavigateToClientActionPlan
            )




            FeatureCard(
                "Sign Out",
                "Log out of your account",
                onSignOutClick  // 👈 passed directly, not named
            )



            FeatureCard(
                "About this App",
                "Learn about the author of this app and its function",
                onNavigateToAbout  // 👈 This should be passed in just like the other FeatureCards
            )




            Spacer(modifier = Modifier.height(16.dp))




        }
    }
}


@Composable
fun SignupScreen(
    supabase: SupabaseClient, onSignupSuccess: () -> Unit, onBack: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var statusMessage by remember { mutableStateOf("") }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Sign Up", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email Address") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirm Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            ModernRaisedButton(
                text = "🆕 Create Account",
                onClick = {
                    if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                        statusMessage = "❗ All fields are required."
                        return@ModernRaisedButton
                    }

                    if (password.trim() != confirmPassword.trim()) {
                        statusMessage = "❗ Passwords do not match."
                        return@ModernRaisedButton
                    }

                    coroutineScope.launch {
                        try {
                            val response: HttpResponse = (context as MainActivity).httpClient.post(
                                "https://ituaxigakgytlknrjkzz.supabase.co/auth/v1/signup"
                            ) {
                                contentType(ContentType.Application.Json)
                                setBody(
                                    mapOf(
                                        "email" to email,
                                        "password" to password
                                    )
                                )
                                headers {
                                    append(
                                        "apikey",
                                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg"
                                    )
                                }
                            }

                            if (response.status.value == 200) {
                                val userId = generateUserId()
                                val newUser = mapOf(
                                    "identifier" to userId,
                                    "email" to email
                                )
                                supabase.from("users").insert(newUser)
                                statusMessage = "✅ Account created!"
                                onSignupSuccess()
                            } else {
                                val responseBody = response.bodyAsText()
                                statusMessage = "❌ Signup failed: $responseBody"
                            }

                        } catch (e: Exception) {
                            statusMessage = "❌ Error: ${e.message}"
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )


            Spacer(modifier = Modifier.height(8.dp))

            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )


            Spacer(modifier = Modifier.height(8.dp))

            if (statusMessage.isNotBlank()) {
                Text(statusMessage)
            }
        }
    }
}


@Composable
fun ChartScreen(entries: List<ObsessionEntry>, onBack: () -> Unit) {
    val barEntries =
        entries.mapIndexed { index, item -> BarEntry(index.toFloat(), item.times.toFloat()) }
    val labels = entries.map { it.compulsion }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text("Compulsion Frequency Chart", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(16.dp))
            BarChartView(barEntries, labels, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.height(16.dp))
            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

        }
    }
}

@Composable
fun BarChartView(entries: List<BarEntry>, labels: List<String>, modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier
            .padding(WindowInsets.statusBars.asPaddingValues())
            .fillMaxWidth()
            .height(500.dp), factory = { context ->
            BarChart(context).apply {
                description.isEnabled = false
                setDrawGridBackground(false)
                setTouchEnabled(true)
                setPinchZoom(true)
                setScaleEnabled(true)
                animateY(1000)/* fitBars(true) */

                val dataSet = BarDataSet(entries, "Compulsion Frequency").apply {
                    color = android.graphics.Color.BLUE
                    valueTextColor = android.graphics.Color.BLACK

                    valueTextSize = 12f
                }

                val barData = BarData(dataSet).apply {
                    barWidth = 0.2f
                }

                data = barData

                xAxis.apply {
                    position = XAxis.XAxisPosition.BOTTOM
                    granularity = 1f
                    setDrawGridLines(false)
                    valueFormatter = IndexAxisValueFormatter(labels)
                    labelRotationAngle = -45f  // ✅ Keeps it readable
                    labelCount = labels.size   // ✅ One label per entry
                    textSize = 10f             // ✅ Slightly smaller
                    isGranularityEnabled = true
                    valueFormatter =
                        IndexAxisValueFormatter(labels.map { it.take(10) }) // first 10 chars

                }

                axisLeft.setDrawGridLines(false)
                axisRight.isEnabled = false

                invalidate()
            }
        })
}

@Composable
fun CopingTechniquesScreen(onBack: () -> Unit) {
    val text = """
        Tracking,

        Anxiety peaks are challenging, especially when dealing with OCD.
        When your thoughts feel overwhelming, the urge to perform compulsions increases,
        and your mind races. Box breathing is a simple yet powerful technique that can
        help calm your nervous system and regain control over your thoughts.

        What Is Box Breathing?
        Box breathing is a technique that focuses on the breath, slowing it down 
        to bring balance to the mind and body. The exercise involves breathing
        in four equal counts: inhale, hold, exhale, and hold again before starting the next cycle.
    """.trimIndent()

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(20.dp))
            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

        }
        }
    }


data class DiaryEntry(
    val date: String, val text: String
)


@Composable
fun DiaryScreen(
    supabase: SupabaseClient, onBack: () -> Unit
) {
    val diaryEntries = remember { mutableStateListOf<JournalEntry>() }
    val context = LocalContext.current
    var newEntryText by remember { mutableStateOf("") }
    var entryToDelete by remember { mutableStateOf<JournalEntry?>(null) }



    LaunchedEffect(Unit) {
        val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
        val userId = prefs.getString("user_id", "") ?: ""

        val fetched = fetchJournalEntriesFilteredLocally(supabase, userId).sortedByDescending {
                Instant.parse(it.created_at)
            }

        diaryEntries.clear()
        diaryEntries.addAll(fetched)
    }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(WindowInsets.statusBars.asPaddingValues())
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "My Diary",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text("New Entry", style = MaterialTheme.typography.titleMedium)

            OutlinedTextField(
                value = newEntryText,
                onValueChange = { newEntryText = it },
                label = { Text("What’s on your mind?") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            ModernRaisedButton(
                text = "📝 Add Entry",
                onClick = {
                    val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
                    val identifier = prefs.getString("user_id", "") ?: ""

                    if (newEntryText.isNotBlank()) {
                        val textToUpload = newEntryText
                        newEntryText = ""

                        val uploadEntry = JournalEntryUpload(
                            identifier = identifier,
                            journalentry = textToUpload
                        )

                        CoroutineScope(Dispatchers.IO).launch {
                            try {
                                supabase.from("journals").insert(uploadEntry)

                                val localEntry = JournalEntry(
                                    id = 0,
                                    created_at = SimpleDateFormat(
                                        "yyyy-MM-dd", Locale.getDefault()
                                    ).format(Date()),
                                    identifier = identifier,
                                    journalentry = textToUpload
                                )

                                withContext(Dispatchers.Main) {
                                    diaryEntries.add(0, localEntry)
                                    Log.d("SUPABASE", "✅ Journal entry added")
                                }
                            } catch (e: Exception) {
                                Log.e("SUPABASE", "❌ Failed to add entry: ${e.message}")
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))

            diaryEntries.forEach { entry ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .combinedClickable(onClick = {}, onLongClick = { entryToDelete = entry }),
                    elevation = CardDefaults.cardElevation(6.dp),
                    shape = RoundedCornerShape(16.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = entry.created_at.take(10),
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(entry.journalentry, style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }

            if (entryToDelete != null) {
                AlertDialog(
                    onDismissRequest = { entryToDelete = null },
                    title = { Text("Delete Entry") },
                    text = { Text("Are you sure you want to delete this journal entry?") },
                    confirmButton = {
                        TextButton(onClick = {
                            CoroutineScope(Dispatchers.IO).launch {
                                try {
                                    supabase.from("journals").delete {
                                            filter { eq("id", entryToDelete!!.id) }
                                        }

                                    withContext(Dispatchers.Main) {
                                        diaryEntries.remove(entryToDelete)
                                        entryToDelete = null
                                    }
                                } catch (e: Exception) {
                                    Log.e("SUPABASE", "❌ Failed to delete entry: ${e.message}")
                                }
                            }
                        }) {
                            Text("Delete")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { entryToDelete = null }) {
                            Text("Cancel")
                        }
                    })
            }

            Spacer(modifier = Modifier.height(20.dp))

            ModernRaisedButton(
                text = "⬅ Back",
                onClick = onBack,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

        }
        }
    }}



// old ocdapp code :

//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun OCDApp(
//    initialCounter: Int,
//    tableState: MutableState<MutableList<ObsessionEntry>>,
//
//    initialSelectedIndex: Int?,
//    prefs: SharedPreferences,
//    onNavigateToCoping: () -> Unit,
//    onNavigateToDiary: () -> Unit,
//    onNavigateToChart: () -> Unit,
//    onNavigateToSoundMenu: () -> Unit,
//    onNavigateToSignup: () -> Unit,
//    onNavigateToPdf: () -> Unit,
//    onNavigateToSearchTherapist: () -> Unit,
//    saveCounter: (Int) -> Unit,
//    saveTable: (List<ObsessionEntry>) -> Unit,
//    supabase: SupabaseClient
//) {
//    val coroutineScope = rememberCoroutineScope()
//    val context = LocalContext.current
//
//
//
//
//
//
//
//
//    var obsessionText by remember { mutableStateOf("") }
//    var compulsionText by remember { mutableStateOf("") }
//    var showDeleteDialog by remember { mutableStateOf(false) }
//    var entryToDeleteIndex by remember { mutableStateOf<Int?>(null) }
//    var tableData by tableState
//    var selectedEntryIndex by remember { mutableStateOf(initialSelectedIndex) }
//    var counter by remember {
//        mutableStateOf(
//            initialSelectedIndex?.let { index -> tableState.value.getOrNull(index)?.times }
//                ?: initialCounter
//        )
//    }
//
//    LaunchedEffect(Unit) {
//        val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
//        val userId = prefs.getString("user_id", "") ?: ""
//        println("DEBUG: Trying to fetch for userId = '$userId'")
//
//        try {
//            val entries = fetchEntriesHttp(userId)
//
//            // Convert Entry to ObsessionEntry
//            val converted = entries.map {
//                ObsessionEntry(
//                    id = it.id,
//                    obsession = it.obsession,
//                    compulsion = it.compulsion,
//                    times = it.times,
//                    identifier = it.identifier
//                )
//            }
//
//            // Replace list (not modify in-place)
//            tableData = converted.reversed().toMutableList()
//
//            println("✅ Table data updated with ${tableData.size} entries")
//
//        } catch (e: Exception) {
//            println("❌ Failed to fetch entries: ${e.message}")
//        }
//    }
//
//
//
//    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .padding(WindowInsets.statusBars.asPaddingValues())
//                .padding(innerPadding)
//                .padding(16.dp)
//                .verticalScroll(rememberScrollState())
//        ) {
//            OutlinedTextField(
//                value = obsessionText,
//                onValueChange = { obsessionText = it },
//                label = { Text("Name of Obsession") },
//                modifier = Modifier.fillMaxWidth()
//
//
//
//
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = compulsionText,
//                onValueChange = { compulsionText = it },
//                label = { Text("Name of Compulsion") },
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Button(onClick = { onNavigateToSignup() }, modifier = Modifier.fillMaxWidth()) {
//                Text("User Sign-Up")
//            }
//
//            Button(onClick = onNavigateToPdf, modifier = Modifier.fillMaxWidth()) {
//                Text("📄 View OCD Thought Log PDF")
//            }
//
//
//            Button(onClick = onNavigateToSoundMenu, modifier = Modifier.fillMaxWidth()) {
//                Text("Sound Menu")
//            }
//
//            Button(
//                onClick = {
//                    if (obsessionText.isNotBlank()) {
//                        val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
//                        val identifier = prefs.getString("identifier", "") ?: ""
//                        val accessToken = prefs.getString("access_token", "") ?: ""
//
//                        val newEntry = ObsessionEntry(
//                            id = 0,
//                            obsession = obsessionText,
//                            compulsion = compulsionText,
//                            times = 0,
//                            identifier = identifier
//                        )
//
//                        coroutineScope.launch {
//                            saveTableToSupabase(newEntry)
//                        }
//                        // Update local table
//                        tableData = (listOf(newEntry) + tableData).toMutableList()
//
//                        saveTable(tableData)
//
//
//                        // Clear input fields
//                        obsessionText = ""
//                        compulsionText = ""
//
//                        CoroutineScope(Dispatchers.IO).launch {
//                            try {
//                                val json = Json.encodeToString(newEntry)
//
//                                val response: HttpResponse = HttpClient(OkHttp).post("https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries") {
//                                    headers {
//                                        append("apikey", BuildConfig.SUPABASE_ANON_KEY)
//                                        append("Authorization", "Bearer $accessToken")
//                                        append("Content-Type", "application/json")
//                                    }
//                                    setBody(
//                                        TextContent(
//                                            text = json,
//                                            contentType = ContentType.Application.Json
//                                        )
//                                    )
//
//                                }
//
//                                if (!response.status.isSuccess()) {
//                                    println("Supabase upload failed: ${response.status}")
//                                }
//                            } catch (e: Exception) {
//                                println("Exception posting: ${e.message}")
//                            }
//                        }
//                    }
//                },
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                Text("Add to Table")
//            }
//
//
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text("Counter: $counter", style = MaterialTheme.typography.titleLarge)
//
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
//                Button(onClick = {
//                    if (selectedEntryIndex != null) {
//                        val index = selectedEntryIndex!!
//                        tableData[index].times++
//                        counter = tableData[index].times
//                        saveTable(tableData)
//                        saveCounter(counter)
//
//                        val updatedTimes = tableData[index].times
//                        val entryId = tableData[index].id
//
//                        val jsonBody = """{ "times": $updatedTimes }"""
//
//                        CoroutineScope(Dispatchers.IO).launch {
//                            try {
//
//                                val client = HttpClient(OkHttp)
//
//                                val url = "https://ituaxigakgytlknrjkzz.supabase.co/rest/v1/entries?id=eq.$entryId"
//
//
//
//                                val response: HttpResponse = client.request(url) {
//                                    method = HttpMethod.Patch
//                                    headers {
//                                        append("apikey", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg")
//                                        append("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Iml0dWF4aWdha2d5dGxrbnJqa3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3NDgwMzUwOTIsImV4cCI6MjA2MzYxMTA5Mn0.2Vj0Mnh6_RWr478CnIWFK3U42o4npS7SCP-pZn8tzkg")
//                                        append("Content-Type", "application/json")
//                                        append("Prefer", "return=minimal")
//                                    }
//
//                                    setBody("""{ "times": $updatedTimes }""")
//                                }
//
//
//                                if (response.status.isSuccess()) {
//                                    Log.d("PATCH_SUCCESS", "✅ Updated times to $updatedTimes")
//                                } else {
//                                    Log.e("PATCH_FAIL", "❌ Failed to update: ${response.status}")
//                                }
//                            } catch (e: Exception) {
//                                Log.e("PATCH_ERROR", "❌ HTTP error: ${e.message}")
//                            }
//                        }
//
//                    }
//                }) {
//                    Text("Increase")
//                }
//
//
//
//
//                Button(onClick = {
//                    counter = 0
//                    saveCounter(counter)
//                }) {
//                    Text("Reset")
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Button(onClick = onNavigateToChart, modifier = Modifier.fillMaxWidth()) {
//                Text("Show Native Chart")
//            }
//
//            Button(onClick = onNavigateToDiary, modifier = Modifier.fillMaxWidth()) {
//                Text("Journal")
//            }
//
//            Button(onClick = onNavigateToCoping, modifier = Modifier.fillMaxWidth()) {
//                Text("Coping Techniques!")
//            }
//
//
//            Button(
//                onClick = onNavigateToSearchTherapist,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 16.dp)
//            ) {
//                Text("Find a Therapist")
//            }
//
//
//
//            Button(
//                onClick = {
//                    val prefs = context.getSharedPreferences("ocd_prefs", Context.MODE_PRIVATE)
//                    prefs.edit().clear().apply() // ✅ Clear all stored data
//
//                    // Force app restart or show login screen
//                    (context as? MainActivity)?.recreate()
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp)
//            ) {
//                Text("🚪 Sign Out")
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text("Table Entries:", style = MaterialTheme.typography.titleMedium)
//
//            tableData.forEachIndexed { index, entry ->
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(vertical = 4.dp)
//                        .clip(RoundedCornerShape(12.dp))
//                        .background(Color(0xFFF0F0F0))
//                        .combinedClickable(
//                            onClick = {
//                                selectedEntryIndex = index
//                                counter = entry.times
//                                prefs.edit().putInt("selected_index", index).apply()
//                                saveCounter(counter)
//                            },
//                            onLongClick = {
//                                showDeleteDialog = true
//                                entryToDeleteIndex = index
//                            }
//                        ),
//                    elevation = CardDefaults.cardElevation(0.dp)
//                ) {
//                    Column(modifier = Modifier.padding(12.dp)) {
//                        Text(
//                            text = "Obsession : ${entry.obsession}",
//                            fontSize = 15.sp,
//                            color = Color.Gray
//                        )
//
//                        Text(
//                            text = "Compulsion : ${entry.compulsion}",
//                            fontSize = 15.sp,
//                            color = Color.Gray
//                        )
//
//                        Box(modifier = Modifier.fillMaxWidth()) {
//                            Text(
//                                text = "Count: ${entry.times}",
//                                fontSize = 16.sp,
//                                color = Color.DarkGray,
//                                modifier = Modifier.align(Alignment.CenterEnd)
//                            )
//                        }
//                    }
//                }
//            }
//
//            if (showDeleteDialog && entryToDeleteIndex != null) {
//                AlertDialog(
//                    onDismissRequest = { showDeleteDialog = false },
//                    title = { Text("Delete Entry") },
//                    text = { Text("Are you sure you want to delete this entry?") },
//                    confirmButton = {
//                        TextButton(onClick = {
//                            val index = entryToDeleteIndex
//                            if (index != null) {
//                                val entry = tableData[index]
//                                CoroutineScope(Dispatchers.IO).launch {
//                                    try {
//                                        supabase.from("entries")
//                                            .delete {
//                                                filter { eq("id", entry.id) }
//                                            }
//
//                                        withContext(Dispatchers.Main) {
//                                            tableData = tableData.toMutableList().apply { removeAt(index) }
//                                            saveTable(tableData)
//                                            if (selectedEntryIndex == index) {
//                                                selectedEntryIndex = null
//                                                counter = 0
//                                            }
//                                            showDeleteDialog = false
//                                            entryToDeleteIndex = null
//                                        }
//                                    } catch (e: Exception) {
//                                        Log.e("SUPABASE_DELETE", "❌ ${e.message}")
//                                    }
//                                }
//                            }
//                        }) {
//                            Text("Delete")
//                        }
//                    },
//                    dismissButton = {
//                        TextButton(onClick = {
//                            showDeleteDialog = false
//                            entryToDeleteIndex = null
//                        }) {
//                            Text("Cancel")
//                        }
//                    }
//                )
//            }
//
//        }
//    }
//}