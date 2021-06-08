function getDate() {

    const date = new Date();
    const monthsList = [
        'January',
        'February',
        'March',
        'April',
        'May',
        'June',
        'July',
        'August',
        'September',
        'October',
        'November',
        'December'
    ];

    const daysList = [
        'Sunday',
        'Monday',
        'Tuesday',
        'Wednesday',
        'Thursday',
        'Friday',
        'Saturday'
    ];

    let year = date.getFullYear();
    let month = monthsList[date.getMonth()];
    let dayMonth = daysList[date.getDay()];
    let day = date.getDate();

    console.log(`${dayMonth} ${month} ${day}th, ${year}`) // I.E. Wednesday June 9th, 2021
}