<?PHP
$data = [
    'banks' => array( 
    [ 
        'address' => '1',
        'type' => 1,
        'openTime' => '08:00',
        'closeTime' => '19:00'
    ],
    [ 
        'address' => '2',
        'type' => 0,
        'openTime' => '10:00',
        'closeTime' => '19:00'
    ],
    [ 
        'address' => '3))',
        'type' => 0,
        'openTime' => '00:00',
        'closeTime' => '00:00'
    ],
    [ 
        'address' => '4',
        'type' => 1,
        'openTime' => '01:00',
        'closeTime' => '12:00'
    ],
    [ 
        'address' => '5)',
        'type' => 0,
        'openTime' => '10:45',
        'closeTime' => '12:00'
    ],
),
'koff' => 0.1
];

header('Content-type: application/json');
echo json_encode( $data );

?>