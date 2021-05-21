package com.moehan.bitbucketdemo

import com.google.gson.Gson
import com.moehan.bitbucketdemo.api.BitbucketApi
import com.moehan.bitbucketdemo.model.*
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BitbucketNetworkApiTest {

    private val mockWebServer = MockWebServer()

    private val client = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.SECONDS)
        .readTimeout(1, TimeUnit.SECONDS)
        .writeTimeout(1, TimeUnit.SECONDS)
        .build()

    private val api = Retrofit.Builder()
        .baseUrl(mockWebServer.url("/"))
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()
        .create(BitbucketApi::class.java)

    @After
    fun shutDownMWS() {
        mockWebServer.shutdown()
    }

    @Test
    fun shouldFetchReposCorrectlyWith200Response() {

        mockWebServer.enqueueResponse("bitbucket_repos_response_200.json", 200)

        runBlocking {

            val actual = api.getAllRepositories()
            val expected = getExpectedResultObj()

            assertEquals(expected, actual)
        }
    }

    fun getExpectedResultObj(): BitbucketRepoListResponse {
        return BitbucketRepoListResponse(
            next = "https://api.bitbucket.org/2.0/repositories?after=2011-09-03T12%3A33%3A16.028393%2B00%3A00",
            pageLength = 1,
            repoItems = listOf(
                RepoItem(
                    createdOn = "2011-06-06T03:40:09.505792+00:00",
                    forkPolicy = "allow_forks",
                    fullName = "opensymphony/xwork",
                    hasIssues = false,
                    hasWiki = false,
                    isPrivate = false,
                    language = "java",
                    repoLinks = RepoLinks(
                        avatar = Link(href = "https://bytebucket.org/ravatar/%7B3f630668-75f1-4903-ae5e-8ea37437e09e%7D?ts=java"),
                        branches = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/refs/branches"),
                        clone = listOf(
                            Clone(
                                href = "https://bitbucket.org/opensymphony/xwork.git",
                                name = "https"
                            ),
                            Clone(href = "git@bitbucket.org:opensymphony/xwork.git", name = "ssh")
                        ),
                        commits = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/commits"),
                        downloads = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/downloads"),
                        forks = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/forks"),
                        hooks = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/hooks"),
                        html = Link(href = "https://bitbucket.org/opensymphony/xwork"),
                        issues = null,
                        pullRequests = Link(href="https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/pullrequests"),
                        self = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork"),
                        source = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/src"),
                        tags = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/refs/tags"),
                        watchers = Link(href = "https://api.bitbucket.org/2.0/repositories/opensymphony/xwork/watchers")
                    ),
                    mainBranch = MainBranch(name = "master", type = "branch"),
                    name = "xwork",
                    owner = Owner(
                        accountId = null,
                        displayName = "opensymphony",
                        links = OwnerLinks(
                            avatar = Link(href = "https://bitbucket.org/account/opensymphony/avatar/"),
                            html = Link(href = "https://bitbucket.org/%7Bcedfd0d1-899f-49de-acf7-a2fa8e924b6f%7D/"),
                            self = Link(href = "https://api.bitbucket.org/2.0/users/%7Bcedfd0d1-899f-49de-acf7-a2fa8e924b6f%7D")
                        ),
                        nickname = "opensymphony",
                        type = "user",
                        username = null,
                        uuid = "cedfd0d1-899f-49de-acf7-a2fa8e924b6f"
                    ),
                    project = Project(
                        key = "PROJ",
                        links = ProjectLinks(
                            avatar = Link(href = "https://bitbucket.org/account/user/opensymphony/projects/PROJ/avatar/32?ts=1543460518"),
                            html = Link(href = "https://bitbucket.org/opensymphony/workspace/projects/PROJ"),
                            self = Link(href = "https://api.bitbucket.org/2.0/workspaces/opensymphony/projects/PROJ")
                        ),
                        name = "Untitled project",
                        type = "project",
                        uuid = "57fac509-0df2-47ce-ad8e-27be013523fa"
                    ),
                    scm = "git",
                    size = 22877949,
                    slug = "xwork",
                    type = "repository",
                    updatedOn = "2014-11-16T23:19:16.674082+00:00",
                    uuid = "3f630668-75f1-4903-ae5e-8ea37437e09e",
                    website = "",
                    workspace = Workspace(
                        links = WorkSpaceLinks(
                            avatar = Link(href = "https://bitbucket.org/workspaces/opensymphony/avatar/?ts=1543460518"),
                            html = Link(href = "https://bitbucket.org/opensymphony/"),
                            self = Link(href = "https://api.bitbucket.org/2.0/workspaces/opensymphony")
                        ),
                        name = "opensymphony",
                        slug = "opensymphony",
                        type = "workspace",
                        uuid = "cedfd0d1-899f-49de-acf7-a2fa8e924b6f"
                    )
                )
            )
        )
    }
}