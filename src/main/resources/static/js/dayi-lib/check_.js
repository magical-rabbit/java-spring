function check_(){
    if (typeof jQuery === 'undefined') {
        console.error('[dayi-lib]jQuery is not loaded. Make sure it is included before jsGrid.');
        
        return;
    }
    console.log('[dayi-lib-check]jQuery loaded.🔊')

    if (typeof jQuery.fn.jsGrid === 'undefined') {
        console.error('[dayi-lib]jsGrid is not loaded or not defined.');
        return;
    }
    console.log('[dayi-lib-check]jsGrid loaded.🔊')
}