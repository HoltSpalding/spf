knife :- N : knife:<e,t>
box :- N : box:<e,t>
ball :- N : ball:<e,t>
brad :- N : brad:<e,t>
handle :- N : handle:<e,t>
you :- N : self:<e,t>
it :- N : it:<e,t>
obj :- N : (lambda $0:e (obj:<e,t> $0))
mod :- S/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
mod :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
mod :- NP/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
mod :- N/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
blue :- S/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (blue:<e,t> $1) ($0 $1))))
blue :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (blue:<e,t> $1) ($0 $1))))
the :- S/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (def:<e,t> $1) ($0 $1))))
the :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (def:<e,t> $1) ($0 $1))))
the :- NP/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (def:<e,t> $1) ($0 $1))))
a :- NP/N : a:<<e,t>,e>
and :- C : conj:c
, :- C : conj:c
, :- C : disj:c
or :- C : disj:c
pickup :- (S\N)/NP : (lambda $0:<e,t> (lambda $3:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (pickup:<a,t> $1) (actor:<a,<<e,t>,t>> $1 $3)))))
pickup :- S/NP : (lambda $0:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (pickup:<a,t> $1) (actor:<a,<<e,t>,t>> $1 self:<e,t>))))
pick up :- (S\N)/NP : (lambda $0:<e,t> (lambda $3:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (pickup:<a,t> $1) (actor:<a,<<e,t>,t>> $1 $3)))))
pick up :- S/NP : (lambda $0:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (pickup:<a,t> $1) (actor:<a,<<e,t>,t>> $1 self:<e,t>))))
pick up :- (S\N)/N : (lambda $0:<e,t> (lambda $3:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (pickup:<a,t> $1) (actor:<a,<<e,t>,t>> $1 $3)))))
pick up :- S/N : (lambda $0:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (pickup:<a,t> $1) (actor:<a,<<e,t>,t>> $1 self:<e,t>))))
throw :- (S\N)/NP : (lambda $0:<e,t> (lambda $3:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (throw:<a,t> $1) (actor:<a,<<e,t>,t>> $1 $3)))))
throw :- S/NP : (lambda $0:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (throw:<a,t> $1) (actor:<a,<<e,t>,t>> $1 self:<e,t>))))
throw :- (S\N)/N : (lambda $0:<e,t> (lambda $3:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (throw:<a,t> $1) (actor:<a,<<e,t>,t>> $1 $3)))))
throw :- S/N : (lambda $0:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (throw:<a,t> $1) (actor:<a,<<e,t>,t>> $1 self:<e,t>))))
before :- S\S/S : (lambda $1:<a,t> (lambda $2:<a,t> (lambda $0:a (and:<t*,t> (before:<a,t> $0) (conjsubj:<a,<<a,t>,t>> $0 $2) (conjobj:<a,<<a,t>,t>> $0 $1)))))
quickly :- S\S : (lambda $0:<a,t> (lambda $1:a (and:<t*,t> (manner:<a,<<a,t>,t>> $1 quickly:<a,t>)  ($0 $1))))
quickly :- S/S : (lambda $0:<a,t> (lambda $1:a (and:<t*,t> (manner:<a,<<a,t>,t>> $1 quickly:<a,t>)  ($0 $1))))
make sure to :- S/S : (lambda $1:<a,t> (lambda $0:a (modifyaction:<<a,t>,<a,t>> $1 $0)))
by :- S\S/NP : (lambda $1:<e,t> (lambda $2:<a,t> (lambda $0:a (and:<t*,t> (by:<a,t> $0) (prepsubj:<a,<<a,t>,t>> $0 $2) (prepobj:<a,<<e,t>,t>> $0 $1)))))

