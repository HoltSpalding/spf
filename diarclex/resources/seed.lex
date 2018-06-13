that :- NP/N : io:<<e,t>,e>
the :- NP/N : io:<<e,t>,e>
the :- S/N : (lambda $1:<e,t> (lambda $0:e (and:<t*,t> ($1 $0) (definite:<e,t> $0))))
the :- S/N : (lambda $0:<e,t> (def:<<e,t>,t> $0))
knife :- N : knife:<e,t>
box :- N : box:<e,t>
obj :- N : (lambda $0:e (obj:<e,t> $0))
mod :- S/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
mod :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
mod :- NP/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
mod :- N/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (mod:<e,t> $1) ($0 $1))))
blue :- S/N : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (blue:<e,t> $1) ($0 $1))))
blue :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (blue:<e,t> $1) ($0 $1))))
the :- S/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (def:<e,t> $1) ($0 $1))))
the :- NP/NP : (lambda $0:<e,t> (lambda $1:e (and:<t*,t> (def:<e,t> $1) ($0 $1))))
pickup :- S/NP : (lambda $0:<e,t> (lambda $1:a (and:<t*,t> (obj:<a,<<e,t>,t>> $1 (lambda $2:e ($0 $2))) (pickup:<a,t> $1))))
a :- NP/N : a:<<e,t>,e>
and :- C : conj:c
, :- C : conj:c
, :- C : disj:c
or :- C : disj:c