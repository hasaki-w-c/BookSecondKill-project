<!DOCTYPE html>
<html lang="ch-ZN">
<head>
    <meta charset="UTF-8">
    <title>继续等待</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/limonte-sweetalert2/10.12.5/sweetalert2.all.js"></script>
</head>
<body>
<script>
    Swal.fire({
        title: "正在创建订单，请稍后...",
        timer: 3000,
        confirmButtonText: "刷新",
        type: "info"
    }).then(function (result) {
        window.location.href = "/checkKillOrder?konum=${konum}";
    })
</script>
</body>
</html>