function getJson() {
    var username = $("#username").val();
    var password = $("#password").val();
    var str = [];
    str.push({
        "username": username, "password": password
    })
    var json = trans(str);
    console.log(json);
    return json;
};

function trans(str) {
    var json = JSON.stringify(str);
    var e = new RegExp("{", "g");
    json = json.replace(e, "");
    e = new RegExp("}", "g");
    json = json.replace(e, "");
    json = json.replace("[", "{").replace("]", "}");
    return json;
}

function downTxt() {
    let a = getJson();
    let filename = "这是txt文件名称.json"  //注意最好设置后缀.txt\
    var strFile = "c:\\test.txt";
    let value = a
    let elem = document.createElement('a');  //创建a标签
    elem.strFile(strFile);
    elem.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(value));  //设置下载文件内容
    elem.setAttribute('download', filename);  //设置下载文件名
    elem.style.display = 'none';  //设置a标签默认隐藏
    document.body.appendChild(elem);  //添加至dom层
    elem.click();  //执行点击下载事件
    document.body.removeChild(elem);  //使用下载后移除a标签
}

function browseFolder(path) {
    try {
        var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939";  // 选择框提示信息
        var Shell = new ActiveXObject("Shell.Application");
        var Folder = Shell.BrowseForFolder(0, Message, 64, 17);  // 起始目录为：我的电脑
        // var Folder = Shell.BrowseForFolder(0, Message, 0);  // 起始目录为：桌面
        if (Folder != null) {
            Folder = Folder.items();  //  返回 FolderItems 对象
            Folder = Folder.item();  //  返回 Folderitem 对象
            Folder = Folder.Path;  //  返回路径
            if (Folder.charAt(Folder.length - 1) != "\\") {
                Folder = Folder + "\\";
            }
            document.getElementById(path).value = Folder;
            return Folder;
        }
    }
    catch (e) {
        alert(e.message);
    }
}

var Downer = (function (files) {
    var h5Down = !/Trident|MSIE/.test(navigator.userAgent);
    // try{
    // 	h5Down = document.createElement("a").hasOwnProperty("download");
    // } catch(e){
    // 	h5Down = document.createElement("a").download;
    // }

    /**
     * 在支持 download 属性的情况下使用该方法进行单个文件下载
     * @param  {String} fileName
     * @param  {String|FileObject} contentOrPath
     * @return {Null}
     */
    function downloadFile(fileName, contentOrPath) {
        var aLink = document.createElement("a"),
            evt = document.createEvent("HTMLEvents"),
            isData = contentOrPath.slice(0, 5) === "data:",
            isPath = contentOrPath.lastIndexOf(".") > -1;

        // 初始化点击事件
        evt.initEvent("click");

        // 添加文件下载名
        aLink.download = fileName;

        // 如果是 path 或者 dataURL 直接赋值
        // 如果是 file 或者其他内容，使用 Blob 转换
        aLink.href = isPath || isData ? contentOrPath
            : URL.createObjectURL(new Blob([contentOrPath]));

        aLink.dispatchEvent(evt);
    }

    /**
     * [IEdownloadFile description]
     * @param  {String} fileName
     * @param  {String|FileObject} contentOrPath
     */
    function IEdownloadFile(fileName, contentOrPath, bool) {
        var isImg = contentOrPath.slice(0, 10) === "data:image",
            ifr = document.createElement('iframe');

        ifr.style.display = 'none';
        ifr.src = contentOrPath;

        document.body.appendChild(ifr);

        // dataURL 的情况
        isImg && ifr.contentWindow.document.write("<img src='" +
            contentOrPath + "' />");

        // 保存页面 -> 保存文件
        // alert(ifr.contentWindow.document.body.innerHTML)
        if (bool) {
            ifr.contentWindow.document.execCommand('SaveAs', false, fileName);
            document.body.removeChild(ifr);
        } else {
            setTimeout(function () {
                ifr.contentWindow.document.execCommand('SaveAs', false, fileName);
                document.body.removeChild(ifr);
            }, 0);
        }
    }

    /**
     * [parseURL description]
     * @param  {String} str [description]
     * @return {String}     [description]
     */
    function parseURL(str) {
        return str.lastIndexOf("/") > -1 ? str.slice(str.lastIndexOf("/") + 1) : str;
    }

    return function (files) {
        // 选择下载函数
        var downer = h5Down ? downloadFile : IEdownloadFile;

        // 判断类型，处理下载文件名
        if (files instanceof Array) {
            for (var i = 0, l = files.length; i < l; i++)
                // bug 处理
                downer(parseURL(files[i]), files[i], true);
        } else if (typeof files === "string") {
            downer(parseURL(files), files);
        } else {
            // 对象
            for (var file in files) downer(file, files[file]);
        }
    }
})();
function down1() {
    Downer("../file/test.txt");
}
function down2() {
    Downer(["../file/test.txt", "../file/test.txt"]);
}
function down3() {
    Downer({
        "1.txt": "../file/test.txt",
        "2.jpg": "../file/test.jpg"
    });
}



function getimg()//另存为存放在服务器上图片到本地的方法
{
    event.returnValue = false;
    show.window.location.href = imgSrc.src;
    timer = setInterval(checkload, 100)
}

function checkload()
{
    if (show.readyState != "complete") {
        //调用document.execCommand方法，'Saveas'表示打开文件另存为对话框命令
        show.document.execCommand('SaveAs');
        clearInterval(timer)
    }
}

