package com.google.android.gms.auth.firstparty.shared;

public enum d {
    CLIENT_LOGIN_DISABLED("ClientLoginDisabled"),
    DEVICE_MANAGEMENT_REQUIRED("DeviceManagementRequiredOrSyncDisabled"),
    SOCKET_TIMEOUT("SocketTimeout"),
    SUCCESS("Ok"),
    UNKNOWN_ERROR("UNKNOWN_ERR"),
    NETWORK_ERROR("NetworkError"),
    SERVICE_UNAVAILABLE("ServiceUnavailable"),
    INTNERNAL_ERROR("InternalError"),
    BAD_AUTHENTICATION("BadAuthentication"),
    EMPTY_CONSUMER_PKG_OR_SIG("EmptyConsumerPackageOrSig"),
    NEEDS_2F("InvalidSecondFactor"),
    NEEDS_POST_SIGN_IN_FLOW("PostSignInFlowRequired"),
    NEEDS_BROWSER("NeedsBrowser"),
    UNKNOWN("Unknown"),
    NOT_VERIFIED("NotVerified"),
    TERMS_NOT_AGREED("TermsNotAgreed"),
    ACCOUNT_DISABLED("AccountDisabled"),
    CAPTCHA("CaptchaRequired"),
    ACCOUNT_DELETED("AccountDeleted"),
    SERVICE_DISABLED("ServiceDisabled"),
    NEED_PERMISSION("NeedPermission"),
    INVALID_SCOPE("INVALID_SCOPE"),
    USER_CANCEL("UserCancel"),
    PERMISSION_DENIED("PermissionDenied"),
    THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED("ThirdPartyDeviceManagementRequired"),
    DM_INTERNAL_ERROR("DeviceManagementInternalError"),
    DM_SYNC_DISABLED("DeviceManagementSyncDisabled"),
    DM_ADMIN_BLOCKED("DeviceManagementAdminBlocked"),
    DM_ADMIN_PENDING_APPROVAL("DeviceManagementAdminPendingApproval"),
    DM_STALE_SYNC_REQUIRED("DeviceManagementStaleSyncRequired"),
    DM_DEACTIVATED("DeviceManagementDeactivated"),
    DM_REQUIRED("DeviceManagementRequired"),
    ALREADY_HAS_GMAIL("ALREADY_HAS_GMAIL"),
    BAD_PASSWORD("WeakPassword"),
    BAD_REQUEST("BadRequest"),
    BAD_USERNAME("BadUsername"),
    DELETED_GMAIL("DeletedGmail"),
    EXISTING_USERNAME("ExistingUsername"),
    LOGIN_FAIL("LoginFail"),
    NOT_LOGGED_IN("NotLoggedIn"),
    NO_GMAIL("NoGmail"),
    REQUEST_DENIED("RequestDenied"),
    SERVER_ERROR("ServerError"),
    USERNAME_UNAVAILABLE("UsernameUnavailable"),
    GPLUS_OTHER("GPlusOther"),
    GPLUS_NICKNAME("GPlusNickname"),
    GPLUS_INVALID_CHAR("GPlusInvalidChar"),
    GPLUS_INTERSTITIAL("GPlusInterstitial"),
    GPLUS_PROFILE_ERROR("ProfileUpgradeError");
    
    private final String X;

    private d(String str) {
        this.X = str;
    }

    public static final d a(String str) {
        d dVar = null;
        d[] values = values();
        int length = values.length;
        int i = 0;
        while (i < length) {
            d dVar2 = values[i];
            if (!dVar2.X.equals(str)) {
                dVar2 = dVar;
            }
            i++;
            dVar = dVar2;
        }
        return dVar;
    }

    public static boolean a(d dVar) {
        if (!(BAD_AUTHENTICATION.equals(dVar) || CAPTCHA.equals(dVar) || NEED_PERMISSION.equals(dVar) || NEEDS_BROWSER.equals(dVar) || USER_CANCEL.equals(dVar) || THIRD_PARTY_DEVICE_MANAGEMENT_REQUIRED.equals(dVar))) {
            boolean z = DEVICE_MANAGEMENT_REQUIRED.equals(dVar) || DM_INTERNAL_ERROR.equals(dVar) || DM_SYNC_DISABLED.equals(dVar) || DM_ADMIN_BLOCKED.equals(dVar) || DM_ADMIN_PENDING_APPROVAL.equals(dVar) || DM_STALE_SYNC_REQUIRED.equals(dVar) || DM_DEACTIVATED.equals(dVar) || DM_REQUIRED.equals(dVar);
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(d dVar) {
        return NETWORK_ERROR.equals(dVar) || SERVICE_UNAVAILABLE.equals(dVar);
    }
}
