package co.gabrielcastro.instagramclone.common.base

import android.content.Context
import co.gabrielcastro.instagramclone.add.data.AddDataSource
import co.gabrielcastro.instagramclone.add.data.AddFakeRemoveDataSource
import co.gabrielcastro.instagramclone.add.data.AddLocalDataSource
import co.gabrielcastro.instagramclone.add.data.AddRepostitory
import co.gabrielcastro.instagramclone.home.data.FeedMemoryCache
import co.gabrielcastro.instagramclone.home.data.HomeDataSourceFactory
import co.gabrielcastro.instagramclone.home.data.HomeRepository
import co.gabrielcastro.instagramclone.login.data.FakeDataSource
import co.gabrielcastro.instagramclone.login.data.LoginRepository
import co.gabrielcastro.instagramclone.post.data.PostLocalDataSource
import co.gabrielcastro.instagramclone.post.data.PostRepository
import co.gabrielcastro.instagramclone.profile.data.PostsMemoryCache
import co.gabrielcastro.instagramclone.profile.data.ProfileDataSourceFactory
import co.gabrielcastro.instagramclone.profile.data.ProfileFakeRemoteDataSource
import co.gabrielcastro.instagramclone.profile.data.ProfileMemoryCache
import co.gabrielcastro.instagramclone.profile.data.ProfileRepository
import co.gabrielcastro.instagramclone.register.data.FakeRegisterDataSource
import co.gabrielcastro.instagramclone.register.data.RegisterRepository
import co.gabrielcastro.instagramclone.splash.data.FakeLocalDataSource
import co.gabrielcastro.instagramclone.splash.data.SplashRepository

object DependencyInjector {

    fun splashRepository() : SplashRepository {
        return SplashRepository(FakeLocalDataSource())
    }
    fun loginRepository() : LoginRepository {
        return LoginRepository(FakeDataSource())
    }

    fun registerEmailRepository() : RegisterRepository {
        return RegisterRepository(FakeRegisterDataSource())
    }

    fun profileRepository() : ProfileRepository {
        return ProfileRepository(
            ProfileDataSourceFactory(ProfileMemoryCache, PostsMemoryCache)
        )
    }

    fun homeRepository() : HomeRepository {
        return HomeRepository(
            HomeDataSourceFactory(FeedMemoryCache)
        )
    }

    fun addRepository() : AddRepostitory {
        return AddRepostitory(
            AddFakeRemoveDataSource(), AddLocalDataSource()
        )
    }

    fun postRepository(context: Context) : PostRepository {
        return PostRepository(
            PostLocalDataSource(context)
        )
    }

}