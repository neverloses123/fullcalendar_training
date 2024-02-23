//const express = require('express');
//const mysql = require('mysql');
//const bodyParser = require('body-parser');
//
//const app = express();
//const PORT = process.env.PORT || 3000;
//
//app.use(bodyParser.urlencoded({ extended: true }));
//app.use(bodyParser.json());
//
//const db = mysql.createConnection({
//    host: '3306',
//    user: 'root',
//    password: '70302isa',
//    database: 'test'
//});
//
//db.connect((err) => {
//    if (err) {
//        console.error('無法連接到MySQL:', err);
//    } else {
//        console.log('已成功連接到MySQL');
//    }
//});
//
//app.post('/api/calendar/add', (req, res) => {
//    const { eventName, startDate, endDate } = req.body;
//
//    const sql = 'INSERT INTO your_table_name (eventName, startDate, endDate) VALUES ('+req.body+')';
//    const values = [eventName, startDate, endDate];
//
//    db.query(sql, values, (err, result) => {
//        if (err) {
//            console.error('儲存資料時發生錯誤:', err);
//            res.status(500).json({ success: false, message: '發生錯誤，無法儲存資料' });
//        } else {
//            console.log('成功儲存資料到MySQL:', result);
//            res.json({ success: true, message: '資料已成功儲存到資料庫' });
//        }
//    });
//});
//
//app.listen(PORT, () => {
//    console.log(`伺服器已啟動，監聽在 http://localhost:${PORT}`);
//});