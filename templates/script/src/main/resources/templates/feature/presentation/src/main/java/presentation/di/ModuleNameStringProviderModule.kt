package %PACKAGE%.presentation.di

import %PACKAGE%.domain.resources.%MODULE_NAME%StringProvider
import %PACKAGE%.presentation.resources.%MODULE_NAME%StringProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
interface %MODULE_NAME%StringProviderModule {

    @Binds
    @IntoMap
    @ClassKey(%MODULE_NAME%StringProvider::class)
    fun bind%MODULE_NAME%StringProvider(
        impl: %MODULE_NAME%StringProviderImpl
    ): %MODULE_NAME%StringProvider

}
