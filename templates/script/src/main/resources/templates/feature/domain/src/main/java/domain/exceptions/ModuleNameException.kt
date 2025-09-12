package %PACKAGE%.domain.exceptions

import %PACKAGE%.domain.exceptions.base.Abstract%MODULE_NAME%AppException
import %PACKAGE%.domain.resources.%MODULE_NAME%StringProvider

class %MODULE_NAME%Exception : Abstract%MODULE_NAME%AppException("Specific feature error") {

    override fun getLocalizedErrorMessage(stringProvider: %MODULE_NAME%StringProvider): String {
        return TODO()
    }

}
