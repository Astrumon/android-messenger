package %PACKAGE%.presentation.resources

import android.content.Context
import %PACKAGE%.domain.resources.%MODULE_NAME%StringProvider
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class %MODULE_NAME%StringProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : %MODULE_NAME%StringProvider {

}
